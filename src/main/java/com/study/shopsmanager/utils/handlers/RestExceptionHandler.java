package com.study.shopsmanager.utils.handlers;

import com.study.shopsmanager.utils.errors.ApiError;
import com.study.shopsmanager.utils.exceptions.ShopNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(value = { RuntimeException.class })
  protected ResponseEntity<Object> handleConflict(RuntimeException e, WebRequest request) {
    if (e instanceof ShopNotFoundException) {
      return handleShopNotFoundException((ShopNotFoundException) e);
    } else {
      return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR));
    }
  }

  protected ResponseEntity<Object> handleShopNotFoundException(ShopNotFoundException e) {
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);

    return buildResponseEntity(apiError);
  }

  private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }
}
