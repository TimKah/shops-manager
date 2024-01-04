package com.study.shopsmanager.dto;

import lombok.Data;

@Data
public class SupplierStockDTO {
  private Long supplier;
  private Long item;
  private Float amount;
}
