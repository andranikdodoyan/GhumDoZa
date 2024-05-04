package com.capstone.GhumDoZa.exception;

public class WrongLoginException extends RuntimeException {

  public WrongLoginException() {
    super("Wrong Credentials");
  }
}
