package com.capstone.GhumDoZa.mapper;

import com.capstone.GhumDoZa.dto.user.UserProfileDto;
import com.capstone.GhumDoZa.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserEntityMapper {

  public UserProfileDto entityToProfile(UserEntity user) {
    return UserProfileDto.builder()
        .id(user.getId())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .build();
  }
}
