package com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


@Entity
@Table(name="category")

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    @ManyToMany(mappedBy = "categories",cascade = CascadeType.MERGE)
    private List<Book> books;
}
