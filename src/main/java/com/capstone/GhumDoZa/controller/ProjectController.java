package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.dto.ProjectListDto;
import com.capstone.GhumDoZa.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/project")
public class ProjectController {

  private final ProjectService projectService;

  @GetMapping(value="/list/{userId}")
  public ResponseEntity<ProjectListDto> getProjectsOfUser(@PathVariable Long userId) {
    return ResponseEntity.ok(projectService.getProjectsOfUser(userId));
  }

}
