package com.study.shopsmanager.utils.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiError {

  private HttpStatus status;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;
  private String message;
  private String debugMessage;

  private ApiError() {
    timestamp = LocalDateTime.now();
  }

  public ApiError(HttpStatus status) {
    this();
    this.status = status;
  }

  public ApiError(HttpStatus status, Throwable e) {
    this(status);
    this.message = "Unexpected error";
    this.debugMessage = e.getLocalizedMessage();
  }

  public ApiError(HttpStatus status, String message, Throwable e) {
    this(status, e);
    this.message = message;
  }
}
