package com.todeb.batuhanayyildiz.libraryautomationapplication.controller;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.BookDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Book;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;


    @GetMapping("/all")
    public ResponseEntity getAllBooks(){
        List<Book> allBooks= bookService.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity getBookById(@PathVariable("id") Long id){
        Book byId = bookService.getBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity createNewBook(@RequestBody BookDTO bookDTO) {
        Book respBook = bookService.createBook(bookDTO);
        if (respBook == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Book could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respBook);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteBook(@RequestParam(name="id") Long id){
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Related Book is deleted successfully");
    }

    @PutMapping("/{name}")
    public ResponseEntity updateBook(
            @PathVariable String name,
            @RequestBody BookDTO bookDTO){
        Book update =bookService.updateBook(name,bookDTO);
        if(update ==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Book could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);


    }




}

