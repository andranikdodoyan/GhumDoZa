package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.dto.project.ProjectDto;
import com.capstone.GhumDoZa.dto.project.ProjectListDto;
import com.capstone.GhumDoZa.service.ProjectService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/project")
public class ProjectController {

  private final ProjectService projectService;

  @GetMapping(value = "/list/{userId}")
  public ResponseEntity<ProjectListDto> getProjectsOfUser(@PathVariable UUID userId) {
    return ResponseEntity.ok(projectService.getProjectsOfUser(userId));
  }

  @PutMapping(value = "/create")
  public ResponseEntity<ProjectDto> create(@RequestBody ProjectDto projectDto) {
    return ResponseEntity.ok(projectService.create(projectDto));
  }

}
