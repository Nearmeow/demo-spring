package com.example.demo.dto;

public class AddUserDtoResponse {

    private Long id;
    private String name;

    public AddUserDtoResponse() {
    }

    public AddUserDtoResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
