package com.capstone.GhumDoZa.exception;

public class ProjectNotFoundByCodeException extends RuntimeException {

  public ProjectNotFoundByCodeException() {
    super("Project Not Found By Project Code");
  }
}
