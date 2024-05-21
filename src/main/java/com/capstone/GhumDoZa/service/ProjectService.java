package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.dto.project.ProjectDto;
import com.capstone.GhumDoZa.dto.project.ProjectListDto;
import com.capstone.GhumDoZa.entity.ProjectEntity;
import com.capstone.GhumDoZa.exception.DuplicateProjectCodeException;
import com.capstone.GhumDoZa.mapper.ProjectEntityMapper;
import com.capstone.GhumDoZa.repository.ProjectRepository;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectService {

  private final ProjectRepository projectRepository;
  private final ProjectEntityMapper projectEntityMapper;

  public ProjectListDto getProjectsOfUser(UUID userId) {
    return ProjectListDto.builder()
        .projectDtos(
            projectRepository.findProjectsOfUserWithId(userId)
                .stream().map(projectEntityMapper::entityToDto)
                .collect(Collectors.toSet()))
        .build();
  }

  public ProjectDto create(ProjectDto projectDto) {
    if (projectRepository.findByCode(projectDto.getCode()).isPresent()) {
      throw new DuplicateProjectCodeException();
    }

    ProjectEntity project = ProjectEntity.builder()
        .creatorId(projectDto.getCreatorId())
        .name(projectDto.getName())
        .code(projectDto.getCode())
        .description(projectDto.getDescription())
        .build();

    projectRepository.save(project);
    return projectEntityMapper.entityToDto(project);
  }
}