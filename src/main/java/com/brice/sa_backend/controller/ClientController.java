package com.brice.sa_backend.controller;

import com.brice.sa_backend.entities.Client;
import com.brice.sa_backend.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {

    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "create", consumes = {"application/json"})
    public void create(@RequestBody Client client) {
        try {
            this.clientService.create(client);
        } catch (Exception e) {
            System.out.println("Exception CREATE " + e.toString());
        }
    }

    @GetMapping(value = "index", produces = {"application/json"})
    public List<Client> index() {
        return this.clientService.index();
    }
}
