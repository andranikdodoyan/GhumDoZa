package com.capstone.GhumDoZa.exception;

public class DuplicateProjectCodeException extends RuntimeException {

  public DuplicateProjectCodeException() {
    super("Duplicate Project Code Not allowed");
  }
}
