package com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class ClientDTO {
    private String name;
    private String surname;
    private String phoneNumber;
    @Email
    private String email;
    private String address;

}
