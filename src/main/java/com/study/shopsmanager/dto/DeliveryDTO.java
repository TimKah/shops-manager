package com.study.shopsmanager.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class DeliveryDTO {
  private SupplierDTO supplier;
  private ShopDTO shop;
  private ItemDTO item;
  private Float amount;
  private Date date;
}
