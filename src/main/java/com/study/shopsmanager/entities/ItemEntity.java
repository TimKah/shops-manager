package com.study.shopsmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "items")
@Getter
@Setter
public class ItemEntity {
  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;
  @NonNull
  private String name;
  private String measure;
}
