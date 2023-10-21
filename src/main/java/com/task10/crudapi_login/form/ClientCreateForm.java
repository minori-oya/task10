package com.task10.crudapi_login.form;

import com.task10.crudapi_login.entity.Client;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class ClientCreateForm {
    public Client convertToClient() {
        Client client = new Client(id, name, age, phoneNumber);
        return client;
    }

    private int id;

    @NotBlank
    private String name;

    @Min(20)
    private int age;

    @Length(min = 10, max = 15)
    private String phoneNumber;

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
