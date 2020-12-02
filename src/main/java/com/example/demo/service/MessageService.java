package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.exception.HelloException;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MessageService {

  private MessageRepository messageRepository;
  private UserRepository userRepository;

  @Autowired
  public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
    this.messageRepository = messageRepository;
    this.userRepository = userRepository;
  }

  public List<MessageDtoResponse> getAllMessages() {
    return messageRepository.findAll().stream()
        .map(message -> new MessageDtoResponse(message.getId(), message.getText()))
        .collect(Collectors.toList());
  }

  public List<GetUsersDtoResponse> getAllUsers() {
    return userRepository.findAll().stream()
        .map(user -> new GetUsersDtoResponse(user.getId(), user.getName(), getMessagesList(user.getMessages())))
        .collect(Collectors.toList());
     //StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
  }

  public MessageDtoResponse addMessage(MessageDtoRequest request) throws HelloException {
    if (!userRepository.existsById(request.getUserId())) {
      throw new HelloException("Invalid user ID");
    }
    Optional<User> optionalUser = userRepository.findById(request.getUserId());
    User user = optionalUser.get();
    Message message = new Message(request.getMessage(), user);
    messageRepository.save(message);

    return new MessageDtoResponse(message.getId(), message.getText());
  }

  public AddUserDtoResponse addUser(AddUserDtoRequest request) {
    User user = new User(request.getName());
    userRepository.save(user);

    return new AddUserDtoResponse(user.getId(), user.getName());
  }

  private Set<MessageDtoResponse> getMessagesList(Set<Message> set) {
    Set<MessageDtoResponse> resultSet = new HashSet<>();
    for (Message elem : set) {
      resultSet.add(new MessageDtoResponse(elem.getId(), elem.getText()));
    }
    return resultSet;
  }


}
