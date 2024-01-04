package com.study.shopsmanager.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shops_stocks")
@Getter
@Setter
public class ShopStockEntity {
  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "shop_id", referencedColumnName = "id")
  private ShopEntity shop;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "item_id", referencedColumnName = "id")
  private ItemEntity item;
  private Float amount;
}
