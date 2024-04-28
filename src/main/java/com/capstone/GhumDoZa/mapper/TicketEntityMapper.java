package com.capstone.GhumDoZa.mapper;

import com.capstone.GhumDoZa.dto.ticket.TicketDto;
import com.capstone.GhumDoZa.entity.TicketEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TicketEntityMapper {

  public TicketDto entityToDto(TicketEntity entity) {
    return TicketDto.builder()
        .id(entity.getId())
        .status(entity.getStatus())
        .build();
  }
}
