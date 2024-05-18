package com.capstone.GhumDoZa.dto.team;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TeamAddMemberDto {

  private String teamId;
  private String userId;
  private String role;

}
