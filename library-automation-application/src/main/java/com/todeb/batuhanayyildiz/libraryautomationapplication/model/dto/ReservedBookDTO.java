package com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Book;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.User;

import javax.persistence.OneToOne;
import java.time.LocalDate;

public class ReservedBookDTO {

    private User user; // The person who makes reservation
    private Book book;
    private LocalDate reservedDate;
    private LocalDate returnDate;
}
