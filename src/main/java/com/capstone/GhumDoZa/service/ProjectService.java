package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.dto.ProjectListDto;
import com.capstone.GhumDoZa.mapper.ProjectEntityMapper;
import com.capstone.GhumDoZa.repository.ProjectRepository;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectService {

  private final ProjectRepository projectRepository;
  private final ProjectEntityMapper projectEntityMapper;

  public ProjectListDto getProjectsOfUser() {
    return ProjectListDto.builder()
        .projectDtos(
            projectRepository.findProjectsOfUserWithId(1L)
                .stream().map(projectEntityMapper::entityToDto)
                .collect(Collectors.toSet()))
        .build();
  }
}