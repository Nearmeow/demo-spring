package com.example.demo.dto;

import java.util.Set;

public class GetUsersDtoResponse {

    private Long id;
    private String name;
    private Set<MessageDtoResponse> messages;

    public GetUsersDtoResponse() {
    }

    public GetUsersDtoResponse(Long id, String name, Set<MessageDtoResponse> messages) {
        this.id = id;
        this.name = name;
        this.messages = messages;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<MessageDtoResponse> getMessages() {
        return messages;
    }
}
