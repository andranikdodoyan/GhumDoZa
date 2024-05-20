package com.capstone.GhumDoZa.dto.ticket;

import com.capstone.GhumDoZa.enums.TicketStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TicketDto {

  private UUID ticketId;
  private UUID projectId;
  private String headline;
  private String body;
  private UUID assigneeId;
  private UUID creatorId;
  private TicketStatus status;
}
