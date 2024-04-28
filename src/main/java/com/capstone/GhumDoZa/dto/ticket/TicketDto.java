package com.capstone.GhumDoZa.dto.ticket;

import com.capstone.GhumDoZa.enums.TicketStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TicketDto {

  private Long id;
  private TicketStatus status;
}
