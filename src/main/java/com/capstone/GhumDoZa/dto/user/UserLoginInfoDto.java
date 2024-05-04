package com.capstone.GhumDoZa.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginInfoDto {

  private String login;
  private String password;
  private String firstName;
  private String lastName;
}
