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
@Table(name = "shops")
@Getter
@Setter
public class ShopEntity {
  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;
  @NonNull
  @Column(name = "name")
  private String name;
  @Column(name = "logo")
  private String logoUrl;
}
