package com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ReservedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
    @JoinColumn(name="client_id")
    private Client client; // The person who makes reservation

    @OneToOne(mappedBy = "reservedBook",fetch = FetchType.LAZY)
    private Book book;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate reservationDate=LocalDate.now();

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate returnDate=LocalDate.now().plusDays(30);




}
