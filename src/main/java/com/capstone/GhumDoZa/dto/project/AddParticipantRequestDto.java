package com.capstone.GhumDoZa.dto.project;

import com.capstone.GhumDoZa.enums.UserRole;
import java.util.UUID;
import lombok.Getter;

@Getter
public class AddParticipantRequestDto {

  private UUID projectId;
  private String username;
  private UserRole role;
}
