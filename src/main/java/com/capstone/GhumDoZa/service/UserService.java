package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.dto.user.UserLoginInfoDto;
import com.capstone.GhumDoZa.dto.user.UserProfileDto;
import com.capstone.GhumDoZa.entity.UserEntity;
import com.capstone.GhumDoZa.exception.UserAlreadyExistsException;
import com.capstone.GhumDoZa.exception.WrongLoginException;
import com.capstone.GhumDoZa.mapper.UserEntityMapper;
import com.capstone.GhumDoZa.repository.UserRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordAuthentication passwordAuthentication;

  private final UserEntityMapper userEntityMapper;

  public String getNameById(UUID id) {
    UserEntity user = userRepository.findById(id).orElseThrow();
    return user.getFirstName();
  }

  public UserProfileDto login(UserLoginInfoDto loginInfo) {
    UserEntity user = userRepository.findByLogin(loginInfo.getUsername())
        .orElseThrow();

    if (passwordAuthentication.authenticate(loginInfo.getPassword().toCharArray(),
        user.getPassword())) {
      return userEntityMapper.entityToProfile(user);
    } else {
      throw new WrongLoginException();
    }
  }

  public UserProfileDto register(UserLoginInfoDto loginInfoDto) {
    String login = loginInfoDto.getUsername();
    if (userRepository.existsByLogin(login)) {
      throw new UserAlreadyExistsException();
    }
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