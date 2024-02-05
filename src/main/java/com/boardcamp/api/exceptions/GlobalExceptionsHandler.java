package com.boardcamp.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionsHandler {
  @ExceptionHandler({ NameConflictException.class })
  public ResponseEntity<String> handlerNameConflict(NameConflictException exception) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
  }

  @ExceptionHandler({ NotFoundException.class })
public ResponseEntity<String> handlerNotFound(NotFoundException exception) {
  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
}
}

