package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.dto.project.AddParticipantRequestDto;
import com.capstone.GhumDoZa.dto.project.ProjectDto;
import com.capstone.GhumDoZa.dto.project.ProjectListDto;
import com.capstone.GhumDoZa.dto.project.ProjectParticipantDto;
import com.capstone.GhumDoZa.dto.project.RemoveParticipantRequestDto;
import com.capstone.GhumDoZa.entity.ProjectEntity;
import com.capstone.GhumDoZa.entity.UserEntity;
import com.capstone.GhumDoZa.entity.relationEntity.ProjectUserEntity;
import com.capstone.GhumDoZa.exception.DuplicateProjectCodeException;
import com.capstone.GhumDoZa.exception.UserDeletionNotSuppertedException;
import com.capstone.GhumDoZa.exception.UserNotFoundException;
import com.capstone.GhumDoZa.mapper.ProjectEntityMapper;
import com.capstone.GhumDoZa.mapper.UserEntityMapper;
import com.capstone.GhumDoZa.repository.ProjectRepository;
import com.capstone.GhumDoZa.repository.TicketRepository;
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
  private final TicketRepository ticketRepository;

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
        .ticketSequenceCode(0)
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

  public List<ProjectParticipantDto> addParticipant(
      AddParticipantRequestDto addParticipantRequestDto) {
    UserEntity user = userRepository.findByUsername(addParticipantRequestDto.getUsername())
        .orElseThrow(UserNotFoundException::new);

    //If not added previously
    if (!projectUserRepository
        .existsByProjectIdAndUserId(addParticipantRequestDto.getProjectId(), user.getId())) {
      ProjectUserEntity projectUserEntity = ProjectUserEntity.builder()
          .userId(user.getId())
          .projectId(addParticipantRequestDto.getProjectId())
          .role(addParticipantRequestDto.getRole())
          .build();
      projectUserRepository.save(projectUserEntity);
    }

    return getParticipants(addParticipantRequestDto.getProjectId());
  }

  public List<ProjectParticipantDto> removeParticipant(RemoveParticipantRequestDto requestDto) {
    if(!ticketRepository.findAllByAssigneeId(requestDto.getUserId()).stream()
        .filter(t -> t.getProjectId().equals(requestDto.getProjectId()))
        .toList().isEmpty()){
      throw new UserDeletionNotSuppertedException();
    }
    ProjectUserEntity projectUser = projectUserRepository
        .findByProjectIdAndUserId(requestDto.getProjectId(), requestDto.getUserId())
        .orElseThrow(RuntimeException::new);

    projectUserRepository.delete(projectUser);
    return getParticipants(requestDto.getProjectId());
  }
}