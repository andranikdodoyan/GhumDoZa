package com.capstone.GhumDoZa.dto.comment;

import java.time.Instant;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentDto {

  private String body;
  private String creatorName;
  private Instant createdAt;
}
