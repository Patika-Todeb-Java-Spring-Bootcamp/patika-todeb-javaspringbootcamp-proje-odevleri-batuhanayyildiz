package com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;


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

    @OneToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "book_id")
    private ReservedBook reservedBook;

    @ManyToMany(cascade=CascadeType.MERGE)
    private List<Writer> writers;
    @ManyToMany(cascade=CascadeType.MERGE)
    private List<Category> categories;


}
