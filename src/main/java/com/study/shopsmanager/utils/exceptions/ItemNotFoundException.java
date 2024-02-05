package com.study.shopsmanager.utils.exceptions;

public class ItemNotFoundException extends RuntimeException {
  public ItemNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}