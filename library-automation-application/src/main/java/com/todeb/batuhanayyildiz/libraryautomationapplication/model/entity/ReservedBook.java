package com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private User user; // The person who makes reservation

    @OneToOne
    private Book book;

    private LocalDate reservedDate;
    private LocalDate returnDate;




}
