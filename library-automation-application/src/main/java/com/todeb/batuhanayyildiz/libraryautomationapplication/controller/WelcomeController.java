package com.todeb.batuhanayyildiz.libraryautomationapplication.controller;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.response.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    // http://localhost:8080/URI
    @GetMapping("/welcome")
    public ResponseEntity welcomeMessageApi(){
       String welcomeMsg= "Welcome to Library Automation Application";
       ResponseModel responseModel= new ResponseModel();
       responseModel.setWelcomeMessage((welcomeMsg));
       return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }
}
