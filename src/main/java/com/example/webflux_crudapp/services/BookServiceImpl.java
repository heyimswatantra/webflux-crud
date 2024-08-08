package com.example.webflux_crudapp.services;

import com.example.webflux_crudapp.dao.BookRepository;
import com.example.webflux_crudapp.model.Book;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Mono<Book> saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Mono<Book> updateBook(Long id, Book book) {
        return bookRepository.findById(id).map(Optional::of)
                .defaultIfEmpty(Optional.empty())
                .flatMap(oldBook -> {
                    if(oldBook.isPresent()) {
                        book.setUuid(id);
                        return bookRepository.save(book);
                    }
                    return Mono.empty();
                });
    }

    @Override
    public Mono<Void> deleteBook(Long id) {
        return bookRepository.deleteById(id);
    }
}
