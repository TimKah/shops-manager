package com.study.shopsmanager.utils.exceptions;

public class ShopNotFoundException extends RuntimeException {
  public ShopNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}
