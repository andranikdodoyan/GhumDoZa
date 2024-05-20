package com.capstone.GhumDoZa.dto.ticket;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TicketCreateRequestDto {
  String headline;
  String body;
  String projectCode;
  String creatorId;
  String assigneeId;

}
