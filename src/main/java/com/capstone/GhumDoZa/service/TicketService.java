package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.dto.ticket.TicketDto;
import com.capstone.GhumDoZa.dto.ticket.TicketListDto;
import com.capstone.GhumDoZa.entity.TicketEntity;
import com.capstone.GhumDoZa.exception.TicketNotFoundException;
import com.capstone.GhumDoZa.mapper.TicketEntityMapper;
import com.capstone.GhumDoZa.repository.TicketRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
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

  public TicketListDto getTicketsOfUser(UUID userId) {
    List<TicketEntity> tickets = ticketRepository.findAllByAssigneeId(userId);
    return TicketListDto.builder()
        .ticketDtos(tickets.stream()
            .map(ticketEntityMapper::entityToDto)
            .collect(Collectors.toSet()))
        .build();
  }

  public TicketListDto getTicketsOfProject(UUID projectId) {
    List<TicketEntity> tickets = ticketRepository.findAllByProjectId(projectId);
    return TicketListDto.builder()
        .ticketDtos(tickets.stream()
            .map(ticketEntityMapper::entityToDto)
            .collect(Collectors.toSet()))
        .build();
  }
}