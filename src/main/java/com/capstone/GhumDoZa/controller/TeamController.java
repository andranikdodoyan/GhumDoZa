package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.dto.team.TeamAddMemberDto;
import com.capstone.GhumDoZa.dto.team.TeamDto;
import com.capstone.GhumDoZa.dto.team.TeamListDto;
import com.capstone.GhumDoZa.service.TeamService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/team")
public class TeamController {

  private final TeamService teamService;

  @GetMapping("/list/{userId}")
  public ResponseEntity<TeamListDto> getTeamsOfUser(@PathVariable UUID userId) {
    return ResponseEntity.ok(teamService.getTeamsOfUser(userId));
  }

  @PostMapping("/add")
  public ResponseEntity<TeamDto> addTeamMember(@RequestBody TeamAddMemberDto teamAddMemberDto) {
    return ResponseEntity.ok(teamService.addUser(teamAddMemberDto));
  }
}
