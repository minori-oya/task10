package com.task10.crudapi_login.service;

import com.task10.crudapi_login.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();

    Client findById(int id);

}
