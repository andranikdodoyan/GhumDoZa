package com.capstone.GhumDoZa.dto.team;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TeamListDto {

  private Set<TeamDto> teamDtos;
}
