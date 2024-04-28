package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.dto.ticket.TicketDto;
import com.capstone.GhumDoZa.entity.TicketEntity;
import com.capstone.GhumDoZa.exception.TicketNotFoundException;
import com.capstone.GhumDoZa.mapper.TicketEntityMapper;
import com.capstone.GhumDoZa.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TicketService {

  private final TicketRepository ticketRepository;
  private final TicketEntityMapper ticketEntityMapper;

  @Transactional
  public TicketDto updateStatus(TicketDto ticketDto) {
    TicketEntity ticket = ticketRepository.findById(ticketDto.getId())
        .orElseThrow(TicketNotFoundException::new);
    ticket.setStatus(ticketDto.getStatus());
    ticketRepository.save(ticket);
    return ticketEntityMapper.entityToDto(ticket);
  }
}