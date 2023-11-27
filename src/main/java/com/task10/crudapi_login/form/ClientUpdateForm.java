package com.task10.crudapi_login.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class ClientUpdateForm {

    @NotBlank
    private String name;

    @Min(20)
    private int age;

    @Length(min = 10, max = 15)
    private String phoneNumber;

    public ClientUpdateForm(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
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
