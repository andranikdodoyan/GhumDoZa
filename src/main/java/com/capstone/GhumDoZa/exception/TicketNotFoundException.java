package com.capstone.GhumDoZa.exception;

public class TicketNotFoundException extends RuntimeException {

  public TicketNotFoundException() {
    super("ticket not found");
  }
}
