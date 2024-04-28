package com.capstone.GhumDoZa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectDto {

  private String name;
  private String code;
  private String creatorUsername;
}
