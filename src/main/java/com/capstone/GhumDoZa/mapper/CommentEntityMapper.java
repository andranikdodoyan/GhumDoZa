package com.capstone.GhumDoZa.mapper;

import com.capstone.GhumDoZa.dto.comment.CommentDto;
import com.capstone.GhumDoZa.entity.CommentEntity;
import com.capstone.GhumDoZa.entity.UserEntity;
import com.capstone.GhumDoZa.exception.UserNotFoundException;
import com.capstone.GhumDoZa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentEntityMapper {

  private final UserRepository userRepository;

  public CommentDto entityToDto(CommentEntity entity) {
    UserEntity creator = userRepository.findById(entity.getCreatorId())
        .orElseThrow(UserNotFoundException::new);
    return CommentDto.builder()
        .body(entity.getBody())
        .creatorName(creator.getFirstName() + " " + creator.getLastName())
        .createdAt(entity.getCreatedAt())
        .build();
  }
}
