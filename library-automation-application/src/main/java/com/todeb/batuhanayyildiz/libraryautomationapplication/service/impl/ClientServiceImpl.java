package com.todeb.batuhanayyildiz.libraryautomationapplication.service.impl;


import com.todeb.batuhanayyildiz.libraryautomationapplication.exception.NotFoundException;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.dto.ClientDTO;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity.Client;
import com.todeb.batuhanayyildiz.libraryautomationapplication.model.mapper.ClientMapper;
import com.todeb.batuhanayyildiz.libraryautomationapplication.repository.ClientRepository;
import com.todeb.batuhanayyildiz.libraryautomationapplication.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private static final ClientMapper CLIENT_MAPPER = Mappers.getMapper(ClientMapper.class);

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id){
        Optional<Client> byId = clientRepository.findById(id);
        return byId.orElseThrow(()-> new NotFoundException("Client"));
    }

    @Override
    public Client createClient(ClientDTO clientDTO){
        Client client = CLIENT_MAPPER.toEntity(clientDTO);
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(String clientName,ClientDTO clientDTO) {
        Optional<Client> clientByName = clientRepository.findClientByName(clientName);
        if (!clientByName.isPresent()) {
            throw new NotFoundException("Client");
        }
        Client updatedClient = clientByName.get();
        if (!ObjectUtils.isEmpty(clientDTO.getName())){
            updatedClient.setName(clientDTO.getName());
        }
        if (!ObjectUtils.isEmpty(clientDTO.getSurname())){
            updatedClient.setSurname(clientDTO.getSurname());
        }

        if (!ObjectUtils.isEmpty(clientDTO.getPhoneNumber())){
            updatedClient.setPhoneNumber(clientDTO.getPhoneNumber());
        }

        if (!ObjectUtils.isEmpty(clientDTO.getEmail())){
            updatedClient.setEmail(clientDTO.getEmail());
        }

        if (!ObjectUtils.isEmpty(clientDTO.getAddress())){
            updatedClient.setAddress(clientDTO.getAddress());
        }
        return clientRepository.save(updatedClient);
    }

    @Override
    public boolean deleteClient(Long clientId){
        Client client=getClientById(clientId);
        if(!ObjectUtils.isEmpty(client)){
            clientRepository.delete(getClientById(clientId));
            return true;
        }
        else throw new NotFoundException("id"+""+clientId.toString());

    }

}
