package com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity;

import com.todeb.batuhanayyildiz.libraryautomationapplication.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client extends Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
