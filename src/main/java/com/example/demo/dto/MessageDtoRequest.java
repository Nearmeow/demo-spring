package com.example.demo.dto;

public class MessageDtoRequest {
  private String message;
  private Long userId;

  public MessageDtoRequest() {
  }

  public MessageDtoRequest(String message, Long userId) {
    this.message = message;
    this.userId = userId;
  }

  /*public MessageDtoRequest(String message) {
    this.message = message;
  }*/

  public String getMessage() {
    return message;
  }

  public Long getUserId() {
    return userId;
  }
}
