package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.dto.user.UserLoginInfoDto;
import com.capstone.GhumDoZa.dto.user.UserProfileDto;
import com.capstone.GhumDoZa.entity.UserEntity;
import com.capstone.GhumDoZa.exception.UserAlreadyExistsException;
import com.capstone.GhumDoZa.exception.UserNotFoundException;
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

  public UserProfileDto getNameById(UUID id) {
    return userRepository.findById(id).map(userEntityMapper::entityToProfile).orElseThrow();
  }

  public UserProfileDto login(UserLoginInfoDto loginInfo) {
    UserEntity user = userRepository.findByUsername(loginInfo.getUsername())
        .orElseThrow(UserNotFoundException::new);
    if (passwordAuthentication.authenticate(loginInfo.getPassword().toCharArray(),
        user.getPassword())) {
      return userEntityMapper.entityToProfile(user);
    } else {
      throw new WrongLoginException();
    }
  }

  public UserProfileDto register(UserLoginInfoDto loginInfoDto) {
    String login = loginInfoDto.getUsername();
    if (userRepository.existsByUsername(login)) {
      throw new UserAlreadyExistsException();
    }
    String hashedPassword = passwordAuthentication.hash(loginInfoDto.getPassword().toCharArray());

    UserEntity user = UserEntity.builder()
        .username(login)
        .password(hashedPassword)
        .firstName(loginInfoDto.getFirstName())
        .lastName(loginInfoDto.getLastName())
        .build();
    userRepository.saveAndFlush(user);

    return userEntityMapper.entityToProfile(user);
  }

  public UserProfileDto getUserProfileByUsername(String username) {
    UserEntity user = userRepository.findByUsername(username)
        .orElseThrow(UserNotFoundException::new);

    return UserProfileDto.builder()
        .id(user.getId())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .build();
  }
}