package com.example.demo.dto;

public class MessageDtoResponse {

  private Long id;
  private String message;

  public MessageDtoResponse(Long id, String message) {
    this.id = id;
    this.message = message;
  }

  public Long getId() {
    return id;
  }

  public String getMessage() {
    return message;
  }
}
