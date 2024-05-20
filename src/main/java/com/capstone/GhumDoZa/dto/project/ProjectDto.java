package com.capstone.GhumDoZa.dto.project;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectDto {

  private UUID projectId;
  private String name;
  private String code;
  private UUID creatorId;
  private String description;
}
