package com.task10.crudapi_login.form;

import com.task10.crudapi_login.entity.Client;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class ClientUpdateForm {

    @Min(20)
    private int age;

    @Length(min = 10, max = 15)
    private String phoneNumber;

    public ClientUpdateForm(int age, String phoneNumber) {
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
