package com.study.shopsmanager.utils.exceptions;

public class DeliveryNotFoundException extends RuntimeException {
  public DeliveryNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}
