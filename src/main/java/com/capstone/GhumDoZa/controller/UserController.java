package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.dto.user.UserLoginInfoDto;
import com.capstone.GhumDoZa.dto.user.UserProfileDto;
import com.capstone.GhumDoZa.service.UserService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

  private final UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<String> getUserName(@PathVariable UUID id) {
    return ResponseEntity.ok(userService.getNameById(id));
  }

  @GetMapping("/login")
  public ResponseEntity<UserProfileDto> login(@RequestBody UserLoginInfoDto loginInfo) {
    return ResponseEntity.ok(userService.login(loginInfo));
  }

  @PutMapping(value="/register")
  public ResponseEntity<UserProfileDto> register(
      @RequestBody UserLoginInfoDto loginInfoDto
  ) {
    return ResponseEntity.ok(userService.register(loginInfoDto));
  }
}
