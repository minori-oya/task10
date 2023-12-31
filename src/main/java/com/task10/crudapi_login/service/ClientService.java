package com.task10.crudapi_login.service;

import com.task10.crudapi_login.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();

    Client findById(int id);

    Client create(Client client);

    Client update(int id, String name, int age, String phoneNumber);

    void delete(int id);

    void deleteName(String name);
}
