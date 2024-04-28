package com.capstone.GhumDoZa.dto.project;

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
