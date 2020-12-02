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

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  public Message() {
  }

  public Message(String text, User user) {
    this.text = text;
    this.user = user;
  }

  /*public Message(String text) {
    this.text = text;
  }*/

  public Long getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public User getUser() {
    return user;
  }

  /*@Override
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
  }*/

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Message)) return false;
    Message message = (Message) o;
    return Objects.equals(getId(), message.getId()) &&
            Objects.equals(getText(), message.getText()) &&
            Objects.equals(getUser(), message.getUser());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getText(), getUser());
  }
}
