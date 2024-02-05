package com.study.shopsmanager.utils.exceptions;

public class SupplierNotFoundException extends RuntimeException {
  public SupplierNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}
