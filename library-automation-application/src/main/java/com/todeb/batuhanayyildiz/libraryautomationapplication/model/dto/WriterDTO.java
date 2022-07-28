package com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Book;
import lombok.Data;

import java.util.List;
@Data
public class WriterDTO {

    private String name;
    private String surname;
    private String about;
    private List<Book> books;

}
