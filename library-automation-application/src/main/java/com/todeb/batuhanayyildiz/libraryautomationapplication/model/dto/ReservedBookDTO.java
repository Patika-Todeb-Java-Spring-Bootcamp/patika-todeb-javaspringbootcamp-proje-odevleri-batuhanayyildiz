package com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Book;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Client;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservedBookDTO {

    private Client client; // The person who makes reservation
    private Book book;
    private LocalDate reservationDate;
    private LocalDate returnDate;
}
