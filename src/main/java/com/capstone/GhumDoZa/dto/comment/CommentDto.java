package com.capstone.GhumDoZa.dto.comment;

import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentDto {

  private String body;
  private UUID creatorId;
  private Instant createdAt;
  private UUID ticketId;
}
