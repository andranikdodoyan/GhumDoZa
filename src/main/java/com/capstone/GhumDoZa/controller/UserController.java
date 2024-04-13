package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/user/{id}")
  public ResponseEntity<String> getUserName(@PathVariable Long id) {
    return ResponseEntity.ok(userService.getNameById(id));
  }
}
