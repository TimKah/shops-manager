package com.study.shopsmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "suppliers")
@Getter
@Setter
public class SupplierEntity {
  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;
  private String name;
}
