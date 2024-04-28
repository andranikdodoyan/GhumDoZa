package com.capstone.GhumDoZa.mapper;

import com.capstone.GhumDoZa.dto.team.TeamDto;
import com.capstone.GhumDoZa.entity.TeamEntity;
import org.springframework.stereotype.Component;

@Component
public class TeamEntityMapper {

  public TeamDto entityToDto(TeamEntity entity) {
    return TeamDto.builder()
        .name(entity.getName())
        .build();
  }
}
