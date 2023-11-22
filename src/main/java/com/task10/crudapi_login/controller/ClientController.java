package com.task10.crudapi_login.controller;

import com.task10.crudapi_login.form.ClientCreateForm;
import com.task10.crudapi_login.entity.Client;
import com.task10.crudapi_login.form.ClientUpdateForm;
import com.task10.crudapi_login.service.ClientService;

import static org.springframework.web.servlet.function.RequestPredicates.path;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class ClientController {
    public final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("clients")
    public List<Client> clients() {
        return clientService.findAll();
    }

    @GetMapping("clients/{id}")
    public ClientResponse findById(@PathVariable("id") int id) {
        Client client = clientService.findById(id);
        return new ClientResponse(client);
    }

    @PostMapping("clients")
    public ResponseEntity<Map<String, String>> create(@RequestBody @Validated ClientCreateForm clientCreateForm, UriComponentsBuilder uriComponentsBuilder) {
        Client client = clientService.create(clientCreateForm.convertToClient());
        URI uri = uriComponentsBuilder
                .path("clients/{id}")
                .buildAndExpand(client.getId())
                .toUri();
        return ResponseEntity.created(uri).body(Map.of("message", "data successfully created"));
    }

    @PatchMapping("clients/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody @Validated ClientUpdateForm clientUpdateForm) {
        clientService.update(id, clientUpdateForm.getAge(), clientUpdateForm.getPhoneNumber());
        return ResponseEntity.ok(Map.of("message", "data successfully updated"));
    }

    @DeleteMapping("clients/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        clientService.delete(id);
        return ResponseEntity.ok(Map.of("message", "data successfully deleted"));
    }

    @DeleteMapping("clients/{name}")
    public ResponseEntity<Map<String, String>> deleteName(@PathVariable("name") String name) {
        clientService.deleteName(name);
        return ResponseEntity.ok(Map.of("message", "data successfully deleted"));
    }
}
