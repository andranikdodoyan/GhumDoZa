package com.capstone.GhumDoZa.exception;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException() {
    super("user not found");
  }
}
