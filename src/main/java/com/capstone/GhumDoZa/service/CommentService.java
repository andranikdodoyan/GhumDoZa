package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.dto.comment.CommentListDto;
import com.capstone.GhumDoZa.entity.CommentEntity;
import com.capstone.GhumDoZa.mapper.CommentEntityMapper;
import com.capstone.GhumDoZa.repository.CommentRepository;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;
  private final CommentEntityMapper commentMapper;

  public CommentListDto getCommentsOfTicket(UUID ticketId) {
    List<CommentEntity> comments = commentRepository.findAllByTicketId(ticketId);
    return CommentListDto.builder()
        .comments(comments.stream().sorted(Comparator.comparing(CommentEntity::getCreatedAt))
            .map(commentMapper::entityToDto)
            .collect(Collectors.toList()))
        .build();
  }
}
