package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/project")
public class ProjectController {

  private final ProjectService projectService;

}
