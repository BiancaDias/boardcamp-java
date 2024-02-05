package com.boardcamp.api.exceptions;

public class NameConflictException extends RuntimeException {
  public NameConflictException(String message) {
    super(message);
  }
}
