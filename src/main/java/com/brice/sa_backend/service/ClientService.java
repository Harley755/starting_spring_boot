package com.brice.sa_backend.service;

import com.brice.sa_backend.entities.Client;
import com.brice.sa_backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client) {
        Client clientFound = this.clientRepository.findByEmail(client.getEmail());
        if (clientFound == null) {
            this.clientRepository.save(client);
        }

    }

    public List<Client> index() {
        return this.clientRepository.findAll();
    }
}
