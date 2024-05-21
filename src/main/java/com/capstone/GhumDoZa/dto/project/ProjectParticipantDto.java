package com.capstone.GhumDoZa.dto.project;

import com.capstone.GhumDoZa.dto.user.UserProfileDto;
import com.capstone.GhumDoZa.enums.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProjectParticipantDto {

  UserProfileDto user;
  UserRole role;
}
