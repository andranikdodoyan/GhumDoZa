package com.capstone.GhumDoZa.dto;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectListDto {

  private Set<ProjectDto> projectDtos;
}
