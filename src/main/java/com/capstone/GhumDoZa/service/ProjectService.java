package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.entity.UserEntity;
import com.capstone.GhumDoZa.repository.ProjectRepository;
import com.capstone.GhumDoZa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectService {

  private final ProjectRepository projectRepository;

}