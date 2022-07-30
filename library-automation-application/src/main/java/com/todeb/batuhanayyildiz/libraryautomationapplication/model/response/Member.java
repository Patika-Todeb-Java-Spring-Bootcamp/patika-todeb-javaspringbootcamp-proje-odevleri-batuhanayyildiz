package com.todeb.batuhanayyildiz.libraryautomationapplication.model.response;

import lombok.Data;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;


@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Member {
    private String name;
    private String surname;
    private String phoneNumber;
    @Email
    private String email;
    private String address;
}
