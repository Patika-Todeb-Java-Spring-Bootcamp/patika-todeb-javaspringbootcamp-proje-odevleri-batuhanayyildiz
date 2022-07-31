package com.todeb.batuhanayyildiz.libraryautomationapplication.controller;

import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.ClientDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Client;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/all")
    public ResponseEntity getAllClients(){
        List<Client> allClients= clientService.getAllClients();
        return ResponseEntity.ok(allClients);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity getClientById(@PathVariable("id") Long id){
        Client byId = clientService.getClientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity createNewClient(@RequestBody ClientDTO clientDTO) {
        Client respClient = clientService.createClient(clientDTO);
        if (respClient == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Client could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respClient);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity deleteClient(@RequestParam(name="id") Long id){
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).body("Related Client is deleted successfully");
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{name}")
    public ResponseEntity updateClient(
            @PathVariable String name,
            @RequestBody ClientDTO clientDTO){
        Client update =clientService.updateClient(name,clientDTO);
        if(update ==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Client could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);


    }

}
