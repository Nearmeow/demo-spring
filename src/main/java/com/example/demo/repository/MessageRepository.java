package com.example.demo.repository;

import com.example.demo.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
  List<Message> findAll();
}