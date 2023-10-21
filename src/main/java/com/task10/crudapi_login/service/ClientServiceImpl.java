package com.task10.crudapi_login.service;

import com.task10.crudapi_login.mapper.ClientMapper;
import com.task10.crudapi_login.entity.Client;
import com.task10.crudapi_login.exception.ClientNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientMapper clientMapper;

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
    public Client createClient(Client client) {
        clientMapper.insertClient(client);
        return client;
    }
}
