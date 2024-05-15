package com.capstone.GhumDoZa.dto.comment;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentListDto {

  List<CommentDto> comments;
}
