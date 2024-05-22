package com.capstone.GhumDoZa.exception;

public class UserDeletionNotSuppertedException extends RuntimeException {

  public UserDeletionNotSuppertedException() {
    super("User has tickets and cannot be dremoved from project");
  }
}
