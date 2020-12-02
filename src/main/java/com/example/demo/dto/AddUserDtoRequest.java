package com.example.demo.dto;

public class AddUserDtoRequest {

    private String name;

    public AddUserDtoRequest() {
    }

    public AddUserDtoRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
