package com.task10.crudapi_login;

import org.springframework.stereotype.Service;

import java.util.List;

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
}
