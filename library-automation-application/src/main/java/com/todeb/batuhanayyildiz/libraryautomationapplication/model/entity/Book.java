package com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String overview;
    private String isbnNo;

    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "reservedBook_id")
    private ReservedBook reservedBook;

    @ManyToMany(mappedBy = "books",cascade=CascadeType.MERGE)
    private List<Writer> writers;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(name = "book_categories",
            joinColumns = @JoinColumn(name = "book_id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "category_id",nullable = false)
            )
    private Set<Category> categories;
    // Set is used to prevent duplication


}
