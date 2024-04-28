package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.dto.team.TeamListDto;
import com.capstone.GhumDoZa.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/team")
public class TeamController {

  private final TeamService teamService;

  @GetMapping("/list/{userId}")
  public ResponseEntity<TeamListDto> getTeamsOfUser(@PathVariable Long userId) {
    return ResponseEntity.ok(teamService.getTeamsOfUser(userId));
  }
}
