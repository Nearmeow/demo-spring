package com.example.demo.controller;


import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.exception.HelloException;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

  private MessageService messageService;

  @Autowired
  public MessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  @GetMapping(value = "/messages/get", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<MessageDtoResponse> getAllMessages() {
    return messageService.getAllMessages();
  }

  @GetMapping(value = "/users/get", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<GetUsersDtoResponse> getAllUsers() {
    return messageService.getAllUsers();
  }

  @PostMapping(value = "/messages/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public MessageDtoResponse addMessage(@RequestBody MessageDtoRequest request) throws HelloException {
    return messageService.addMessage(request);
  }

  @PostMapping(value = "/users/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public AddUserDtoResponse addUser(@RequestBody AddUserDtoRequest request) {
    return messageService.addUser(request);
  }
}
