package com.capstone.GhumDoZa.mapper;

import com.capstone.GhumDoZa.dto.ProjectDto;
import com.capstone.GhumDoZa.entity.ProjectEntity;
import com.capstone.GhumDoZa.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectEntityMapper {

  private final UserService userService;

  public ProjectDto entityToDto(ProjectEntity entity) {
    return ProjectDto.builder()
        .name(entity.getName())
        .code(entity.getCode())
        .creatorUsername(userService.getNameById(entity.getCreatorId()))
        .build();
  }
}
