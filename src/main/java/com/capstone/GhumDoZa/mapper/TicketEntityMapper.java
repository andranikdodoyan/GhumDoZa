package com.capstone.GhumDoZa.mapper;

import com.capstone.GhumDoZa.dto.ticket.TicketDto;
import com.capstone.GhumDoZa.entity.TicketEntity;
import com.capstone.GhumDoZa.enums.TicketStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TicketEntityMapper {

  public TicketDto entityToDto(TicketEntity entity) {
    return TicketDto.builder()
        .ticketId(entity.getId())
        .projectId(entity.getProjectId())
        .creatorId(entity.getCreatorId())
        .status(entity.getStatus())
        .headline(entity.getHeadline())
        .assigneeId(entity.getAssigneeId())
        .body(entity.getBody())
        .build();
  }
}
