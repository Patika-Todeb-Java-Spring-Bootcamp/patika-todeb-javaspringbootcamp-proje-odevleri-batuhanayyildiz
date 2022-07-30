package com.todeb.batuhanayyildiz.libraryautomationapplication.model.response;

import lombok.Data;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Member {
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String adress;
}
