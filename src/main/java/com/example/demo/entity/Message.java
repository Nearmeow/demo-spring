package com.example.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Message {
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @Column(name = "title")
  private String text;

  public Message() {
  }

  public Message(String text) {
    this.text = text;
  }

  public Long getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Message message = (Message) o;
    return Objects.equals(id, message.id) &&
        Objects.equals(text, message.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, text);
  }
}
