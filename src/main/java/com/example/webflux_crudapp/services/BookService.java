package com.example.webflux_crudapp.services;

import com.example.webflux_crudapp.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface BookService {
    Flux<Book> getAllBooks();

    Mono<Book> saveBook(Book book);

    Mono<Book> updateBook(Long id, Book book);

    Mono<Void> deleteBook(Long id);
}
