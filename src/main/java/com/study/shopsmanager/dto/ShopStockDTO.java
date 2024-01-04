package com.study.shopsmanager.dto;

import lombok.Data;

@Data
public class ShopStockDTO {
  private ShopDTO shop;
  private ItemDTO item;
  private Float amount;
}
