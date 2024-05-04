package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.dto.user.UserLoginInfoDto;
import com.capstone.GhumDoZa.dto.user.UserProfileDto;
import com.capstone.GhumDoZa.entity.UserEntity;
import com.capstone.GhumDoZa.mapper.UserEntityMapper;
import com.capstone.GhumDoZa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordAuthentication passwordAuthentication;

  private final UserEntityMapper userEntityMapper;

  public String getNameById(Long id) {
    UserEntity user = userRepository.findById(id).orElseThrow();
    return user.getFirstName();
  }

  public UserProfileDto login(UserLoginInfoDto loginInfo) {
    String hashedPassword = passwordAuthentication.hash(loginInfo.getPassword().toCharArray());

    UserEntity user = userRepository.findByLoginAndPassword(loginInfo.getLogin(), hashedPassword)
        .orElseThrow();
    return userEntityMapper.entityToProfile(user);
  }

  public UserProfileDto register(UserLoginInfoDto loginInfoDto) {
    String login = loginInfoDto.getLogin();
    String hashedPassword = passwordAuthentication.hash(loginInfoDto.getPassword().toCharArray());

    UserEntity user = UserEntity.builder()
        .login(login)
        .password(hashedPassword)
        .firstName(loginInfoDto.getFirstName())
        .lastName(loginInfoDto.getLastName())
        .build();
    userRepository.saveAndFlush(user);

    return userEntityMapper.entityToProfile(user);
  }
}