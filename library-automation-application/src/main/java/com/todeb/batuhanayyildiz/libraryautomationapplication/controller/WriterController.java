package com.todeb.batuhanayyildiz.libraryautomationapplication.controller;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.WriterDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Writer;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl.WriterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/writer")
public class WriterController {
    @Autowired
    private WriterServiceImpl writerService;


    @GetMapping("/all")
    public ResponseEntity getAllWriters(){
        List<Writer> allWriters= writerService.getAllWriters();
        return ResponseEntity.ok(allWriters);
    }

    @GetMapping("/{id}")
    public ResponseEntity getWriterById(@PathVariable("id") Long id){
        Writer byId = writerService.getWriterById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("/create")
    public ResponseEntity createNewWriter(@RequestBody WriterDTO writerDTO) {
        Writer respWriter = writerService.createWriter(writerDTO);
        if (respWriter == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Writer could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respWriter);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteWriter(@RequestParam(name="id") Long id){
        writerService.deleteWriter(id);
        return ResponseEntity.status(HttpStatus.OK).body("Related Writer is deleted successfully");
    }

    @PutMapping("/{name}")
    public ResponseEntity updateWriter(
            @PathVariable String name,
            @RequestBody WriterDTO writerDTO){
        Writer update =writerService.updateWriter(name,writerDTO);
        if(update ==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Writer could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);


    }
}
