package com.capstone.GhumDoZa.dto.ticket;

import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TicketListDto {

  private Set<TicketDto> ticketDtos;
}
