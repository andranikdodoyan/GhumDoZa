package com.capstone.GhumDoZa.mapper;

import com.capstone.GhumDoZa.dto.comment.CommentDto;
import com.capstone.GhumDoZa.entity.CommentEntity;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentEntityMapper {

  public CommentDto entityToDto(CommentEntity entity) {
    return CommentDto.builder()
        .body(entity.getBody())
        .creatorId(entity.getCreatorId())
        .createdAt(entity.getCreatedAt())
        .ticketId(entity.getTicketId())
        .build();
  }

  public CommentEntity dtoToEntity(CommentDto commentDto) {
    CommentEntity comment = CommentEntity.builder()
        .id(UUID.randomUUID())
        .creatorId(commentDto.getCreatorId())
        .body(commentDto.getBody())
        .ticketId(commentDto.getTicketId())
        .createdAt(Instant.now())
        .build();

    return comment;
  }
}
