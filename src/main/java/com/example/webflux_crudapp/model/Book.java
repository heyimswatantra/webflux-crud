package com.example.webflux_crudapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "book_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Book {

    @Id
    private Long uuid;

    private String name;

    private String description;

    private Double price;

    private String author;

    private String genre;

}
