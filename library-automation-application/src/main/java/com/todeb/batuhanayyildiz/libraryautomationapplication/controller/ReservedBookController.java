package com.todeb.batuhanayyildiz.libraryautomationapplication.controller;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.ReservedBookDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.ReservedBook;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl.ReservedBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserved-book")
public class ReservedBookController {

    @Autowired
    private ReservedBookServiceImpl reservedBookService;


    @GetMapping("/all")
    public ResponseEntity getAllReservedBooks(){
        List<ReservedBook> allReservedBooks= reservedBookService.getAllReservedBooks();
        return ResponseEntity.ok(allReservedBooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity getReservedBookById(@PathVariable("id") Long id){
        ReservedBook byId = reservedBookService.getReservedBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity createNewReservedBook(@RequestBody ReservedBookDTO reservedBookDTO) {
        ReservedBook respReservedBook = reservedBookService.createReservedBook(reservedBookDTO);
        if (respReservedBook == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ReservedBook could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respReservedBook);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteReservedBook(@RequestParam(name="id") Long id){
        reservedBookService.deleteReservedBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Related ReservedBook is deleted successfully");
    }

    @PutMapping("/{name}")
    public ResponseEntity updateReservedBook(
            @PathVariable String name,
            @RequestBody ReservedBookDTO reservedBookDTO){
        ReservedBook update =reservedBookService.updateReservedBook(name,reservedBookDTO);
        if(update ==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ReservedBook could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);


    }
}
