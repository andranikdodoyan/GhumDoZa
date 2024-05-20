package com.capstone.GhumDoZa.mapper;

import com.capstone.GhumDoZa.dto.project.ProjectDto;
import com.capstone.GhumDoZa.entity.ProjectEntity;
import com.capstone.GhumDoZa.service.UserService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectEntityMapper {

  private final UserService userService;

  public ProjectDto entityToDto(ProjectEntity entity) {
    return ProjectDto.builder()
        .creatorId(entity.getCreatorId())
        .name(entity.getName())
        .code(entity.getCode())
        .description(entity.getDescription())
        .build();
  }
}
