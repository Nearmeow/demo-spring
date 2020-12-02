package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
  @Id
  @Column(name = "user_id", nullable = false)
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @Column(name = "user_name")
  private String name;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
  private Set<Message> messages = new HashSet<>();
  public Set<Message> getMessages() {
      return this.messages;
  }

  public User() {
  }

  public User(String name) {
      this.name = name;
  }

  public Long getId() {
      return id;
  }

  public String getName() {
      return name;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof User)) return false;
      User user = (User) o;
      return Objects.equals(getId(), user.getId()) &&
              Objects.equals(getName(), user.getName());
  }

  @Override
  public int hashCode() {
      return Objects.hash(getId(), getName());
  }
}
