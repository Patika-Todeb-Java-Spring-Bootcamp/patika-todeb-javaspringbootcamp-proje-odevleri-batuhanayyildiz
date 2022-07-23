package com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;
    private String name;
    private String overview;
    private String isbnNo;

    private List<ReservedBook> reservedBooks;
    private List<Writer> writers;
    private List<Category> categories;


}
