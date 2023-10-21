package com.task10.crudapi_login.controller;

import com.task10.crudapi_login.form.ClientCreateForm;
import com.task10.crudapi_login.entity.Client;
import com.task10.crudapi_login.mapper.ClientMapper;
import com.task10.crudapi_login.service.ClientService;

import static org.springframework.web.servlet.function.RequestPredicates.path;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class ClientController {
    public final ClientService clientService;
    public final ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
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

    @PostMapping("clients")
    public ResponseEntity<Map<String, String>> createClient(@RequestBody @Validated ClientCreateForm clientCreateForm, UriComponentsBuilder uriComponentsBuilder) {
        Client client = clientService.createClient(clientCreateForm.convertToClient());
        URI uri = uriComponentsBuilder
                .path("clients/{id}")
                .buildAndExpand(client.getId())
                .toUri();
        return ResponseEntity.created(uri).body(Map.of("message", "data successfully created"));
    }
}



