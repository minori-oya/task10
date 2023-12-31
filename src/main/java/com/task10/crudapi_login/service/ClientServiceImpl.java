package com.task10.crudapi_login.service;

import com.task10.crudapi_login.exception.ClientBadRequestException;
import com.task10.crudapi_login.mapper.ClientMapper;
import com.task10.crudapi_login.entity.Client;
import com.task10.crudapi_login.exception.ClientNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    @Override
    public List<Client> findAll() {
        return clientMapper.findAll();
    }

    @Override
    public Client findById(int id) {
        Optional<Client> client = clientMapper.findById(id);
        return client.orElseThrow(() -> new ClientNotFoundException("client not found:" + id));
    }

    @Override
    public Client create(Client client) {
        clientMapper.insert(client);
        return client;
    }

    @Override
    public Client update(int id, String name, int age, String phoneNumber) {
        Client client = clientMapper.findById(id).orElseThrow(() -> new ClientNotFoundException("resource not found :" + id));
        client.setName(name);
        client.setAge(age);
        client.setPhoneNumber(phoneNumber);
        clientMapper.update(client);
        return client;
    }

    @Override
    public void delete(int id) {
        clientMapper.findById(id).orElseThrow(() -> new ClientNotFoundException("resource not found :" + id));
        clientMapper.delete(id);
    }

    @Override
    public void deleteName(String name) {
        if (clientMapper.findByName(name).isPresent()) {
            clientMapper.deleteName(name);
        } else {
            throw new ClientBadRequestException("resource is bad Request");
        }
    }
}
