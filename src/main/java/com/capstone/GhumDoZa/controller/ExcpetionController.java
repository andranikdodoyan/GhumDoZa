package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.exception.DuplicateProjectCodeException;
import com.capstone.GhumDoZa.exception.ProjectNotFoundByCodeException;
import com.capstone.GhumDoZa.exception.TicketNotFoundException;
import com.capstone.GhumDoZa.exception.UserAlreadyExistsException;
import com.capstone.GhumDoZa.exception.UserDeletionNotSuppertedException;
import com.capstone.GhumDoZa.exception.UserNotFoundException;
import com.capstone.GhumDoZa.exception.WrongLoginException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcpetionController {

  @ExceptionHandler({TicketNotFoundException.class,
      UserNotFoundException.class,
      ProjectNotFoundByCodeException.class})
  public ResponseEntity<ErrorResponse> handleNotFoundException() {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }

  @ExceptionHandler(WrongLoginException.class)
  public ResponseEntity<ErrorResponse> handleUnathorizedException() {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
  }

  @ExceptionHandler({UserAlreadyExistsException.class,
      DuplicateProjectCodeException.class,
      UserDeletionNotSuppertedException.class})
  public ResponseEntity<ErrorResponse> handleBadRequestException() {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
  }
}
