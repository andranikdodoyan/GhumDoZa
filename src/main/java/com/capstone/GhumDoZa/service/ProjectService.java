package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.dto.project.ProjectDto;
import com.capstone.GhumDoZa.dto.project.ProjectListDto;
import com.capstone.GhumDoZa.dto.project.ProjectParticipantDto;
import com.capstone.GhumDoZa.dto.user.UserProfileDto;
import com.capstone.GhumDoZa.entity.ProjectEntity;
import com.capstone.GhumDoZa.entity.UserEntity;
import com.capstone.GhumDoZa.entity.relationEntity.ProjectUserEntity;
import com.capstone.GhumDoZa.exception.DuplicateProjectCodeException;
import com.capstone.GhumDoZa.exception.UserNotFoundException;
import com.capstone.GhumDoZa.mapper.ProjectEntityMapper;
import com.capstone.GhumDoZa.mapper.UserEntityMapper;
import com.capstone.GhumDoZa.repository.ProjectRepository;
import com.capstone.GhumDoZa.repository.UserRepository;
import com.capstone.GhumDoZa.repository.relationRepository.ProjectUserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectService {

  private final ProjectRepository projectRepository;
  private final ProjectEntityMapper projectEntityMapper;
  private final UserEntityMapper userEntityMapper;
  private final ProjectUserRepository projectUserRepository;
  private final UserRepository userRepository;

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

  public List<ProjectParticipantDto> getParticipants(UUID projectId) {
    List<ProjectUserEntity> projectUserEntities =
        projectUserRepository.findAllByProjectId(projectId);

    List<ProjectParticipantDto> participants = new ArrayList<>();
    projectUserEntities.forEach(pue -> {
      participants.add(ProjectParticipantDto.builder()
          .user(userEntityMapper.entityToProfile(
              userRepository.findById(pue.getUserId())
                  .orElseThrow(UserNotFoundException::new)))
          .role(pue.getRole().getName())
          .build());
    });
    return participants;
  }
}