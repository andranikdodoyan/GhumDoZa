package com.capstone.GhumDoZa.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserProfileDto {

  private String firstName;
  private String lastName;
}
