package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.dto.team.TeamListDto;
import com.capstone.GhumDoZa.mapper.TeamEntityMapper;
import com.capstone.GhumDoZa.repository.TeamRepository;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamService {

  private final TeamRepository teamRepository;
  private final TeamEntityMapper teamEntityMapper;

  public TeamListDto getTeamsOfUser(UUID userId) {
    return TeamListDto.builder()
        .teamDtos(
            teamRepository.findTeamsOfUserWithId(userId)
                .stream().map(teamEntityMapper::entityToDto)
                .collect(Collectors.toSet()))
        .build();
  }
}