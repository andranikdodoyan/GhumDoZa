package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.entity.UserEntity;
import com.capstone.GhumDoZa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public String getNameById(Long id) {
    UserEntity user = userRepository.findById(id).orElseThrow();
    return user.getFirstName();
  }
}