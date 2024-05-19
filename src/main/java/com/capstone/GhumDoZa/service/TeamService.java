package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.dto.team.TeamAddMemberDto;
import com.capstone.GhumDoZa.dto.team.TeamDto;
import com.capstone.GhumDoZa.dto.team.TeamListDto;
import com.capstone.GhumDoZa.entity.relationEntity.TeamUserEntity;
import com.capstone.GhumDoZa.enums.UserRole;
import com.capstone.GhumDoZa.mapper.TeamEntityMapper;
import com.capstone.GhumDoZa.repository.TeamRepository;
import com.capstone.GhumDoZa.repository.relationRepository.TeamUserRepository;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamService {

  private final TeamRepository teamRepository;
  private final TeamUserRepository teamUserRepository;
  private final TeamEntityMapper teamEntityMapper;

  public TeamListDto getTeamsOfUser(UUID userId) {
    return TeamListDto.builder()
        .teamDtos(
            teamRepository.findTeamsOfUserWithId(userId)
                .stream().map(teamEntityMapper::entityToDto)
                .collect(Collectors.toSet()))
        .build();
  }

  public TeamDto addUser(TeamAddMemberDto teamAddMemberDto) {
    TeamUserEntity teamUserEntity = TeamUserEntity.builder()
        .id(UUID.randomUUID())
        .teamId(UUID.fromString(teamAddMemberDto.getTeamId()))
        .userId(UUID.fromString(teamAddMemberDto.getUserId()))
        .role(UserRole.valueOf(teamAddMemberDto.getRole()))
        .build();

    teamUserRepository.save(teamUserEntity);

    return teamEntityMapper.entityToDto(
        teamRepository.findById(UUID.fromString(teamAddMemberDto.getTeamId()))
            .orElseThrow(RuntimeException::new));
  }
}