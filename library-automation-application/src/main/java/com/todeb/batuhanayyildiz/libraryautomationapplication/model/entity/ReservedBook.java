package com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReservedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Client client; // The person who makes reservation

    @OneToOne(mappedBy = "reservedBook")
    private Book book;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate reservationDate=LocalDate.now();

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate returnDate=LocalDate.now().plusDays(30);




}
