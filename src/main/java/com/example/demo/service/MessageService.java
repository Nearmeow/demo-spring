package com.example.demo.service;

import com.example.demo.dto.MessageDtoRequest;
import com.example.demo.dto.MessageDtoResponse;
import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

  private MessageRepository messageRepository;

  @Autowired
  public MessageService(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  public List<MessageDtoResponse> getAllMessages() {
    return messageRepository.findAll().stream()
        .map(message -> new MessageDtoResponse(message.getId(), message.getText()))
        .collect(Collectors.toList());
  }

  public MessageDtoResponse addMessage(MessageDtoRequest request) {
    Message message = new Message(request.getMessage());
    messageRepository.save(message);

    return new MessageDtoResponse(message.getId(), message.getText());
  }
}
