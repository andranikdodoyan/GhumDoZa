package com.capstone.GhumDoZa.dto.project;

import java.util.UUID;
import lombok.Getter;

@Getter
public class RemoveParticipantRequestDto {

  private UUID projectId;
  private UUID userId;
}
