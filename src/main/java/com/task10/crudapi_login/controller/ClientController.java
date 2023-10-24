package com.task10.crudapi_login.controller;

import com.task10.crudapi_login.entity.Client;
import com.task10.crudapi_login.service.ClientService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("clients")
    public List<Client> clients() {
        List<Client> clients = clientService.findAll();
        return clients;
    }

    @GetMapping("clients/{id}")
    public ClientResponse findById(@PathVariable("id") int id) {
        Client client = clientService.findById(id);
        return new ClientResponse(client);
    }
}






