package com.example.webflux_crudapp.controller;

import com.example.webflux_crudapp.model.Book;
import com.example.webflux_crudapp.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@RestController
public class BookController {

    private static final Logger logger = Logger.getLogger(BookController.class.getName());

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/add-book")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/update-book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Book> updateBookById(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/delete-book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteBookById(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }
}
