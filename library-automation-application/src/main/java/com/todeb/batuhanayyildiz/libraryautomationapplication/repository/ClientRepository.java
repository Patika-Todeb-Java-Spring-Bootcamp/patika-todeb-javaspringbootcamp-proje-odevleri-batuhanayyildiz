package com.todeb.batuhanayyildiz.libraryautomationapplication.repository;


import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findClientByName(String clientName);

}
