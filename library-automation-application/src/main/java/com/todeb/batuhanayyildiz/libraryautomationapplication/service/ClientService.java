package com.todeb.batuhanayyildiz.libraryautomationapplication.service;


import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.ClientDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    Client getClientById(Long id);

    Client createClient(ClientDTO clientDTO);

    Client updateClient(String clientName,ClientDTO clientDTO);

    boolean deleteClient(Long id);
}
