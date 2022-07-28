package com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String about;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name = "book_writer",
            joinColumns = @JoinColumn(name = "writer_id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "book_id",nullable = false))
    private List<Book> books;

}
