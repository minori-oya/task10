package com.task10.crudapi_login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
}
