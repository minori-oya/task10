package com.task10.crudapi_login.controller;

import com.task10.crudapi_login.entity.Client;

public class ClientResponse {
    private int id;
    private String name;
    private int age;
    private String phoneNumber;

    public ClientResponse(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.age = client.getAge();
        this.phoneNumber = client.getPhoneNumber();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
