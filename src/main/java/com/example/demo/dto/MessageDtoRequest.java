package com.example.demo.dto;

public class MessageDtoRequest {
  private String message;

  public MessageDtoRequest() {
  }

  public MessageDtoRequest(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
