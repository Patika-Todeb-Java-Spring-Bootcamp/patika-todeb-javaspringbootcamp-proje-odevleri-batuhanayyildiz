package com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.response.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Client extends Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,
            cascade=CascadeType.MERGE)
    private List<ReservedBook> reservedBooks;
}
