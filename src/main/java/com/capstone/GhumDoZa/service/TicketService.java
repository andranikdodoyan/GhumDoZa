package com.capstone.GhumDoZa.service;

import static java.util.Objects.nonNull;

import com.capstone.GhumDoZa.dto.ticket.TicketCreateRequestDto;
import com.capstone.GhumDoZa.dto.ticket.TicketDto;
import com.capstone.GhumDoZa.dto.ticket.TicketListDto;
import com.capstone.GhumDoZa.entity.ProjectEntity;
import com.capstone.GhumDoZa.entity.TicketEntity;
import com.capstone.GhumDoZa.enums.TicketStatus;
import com.capstone.GhumDoZa.exception.TicketNotFoundException;
import com.capstone.GhumDoZa.mapper.TicketEntityMapper;
import com.capstone.GhumDoZa.repository.ProjectRepository;
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
  private final ProjectRepository projectRepository;
  private final TicketEntityMapper ticketEntityMapper;

//  @Transactional
//  public TicketDto updateStatus(TicketDto ticketDto) {
//    TicketEntity ticket = ticketRepository.findById(ticketDto.getId())
//        .orElseThrow(TicketNotFoundException::new);
//    ticket.setStatus(ticketDto.getStatus());
//    ticketRepository.save(ticket);
//    return ticketEntityMapper.entityToDto(ticket);
//  }
//
//
  public TicketListDto getTicketsOfProject(UUID projectId) {
    List<TicketEntity> tickets = ticketRepository.findAllByProjectId(projectId);
    return TicketListDto.builder()
        .ticketDtos(tickets.stream()
            .map(ticketEntityMapper::entityToDto)
            .collect(Collectors.toSet()))
        .build();
  }

  public TicketDto createTicket(TicketCreateRequestDto ticketCreateRequestDto) {
    String projectCode = ticketCreateRequestDto.getProjectCode();
    ProjectEntity project = projectRepository.findByCode(projectCode).get();
    UUID projectId = project.getId();
    int serialNumber = ticketRepository.findAllByProjectId(projectId).size();

    String headline = String.format("[%s - %s] %s", projectCode, serialNumber, ticketCreateRequestDto.getHeadline());
    String body = ticketCreateRequestDto.getBody();
    UUID creatorId = UUID.fromString(ticketCreateRequestDto.getCreatorId());
    TicketStatus status = TicketStatus.TO_DO;

    TicketEntity ticket = new TicketEntity();
    ticket.setProjectId(projectId);
    ticket.setHeadline(headline);
    ticket.setBody(body);
    ticket.setAssigneeId(creatorId);
    ticket.setCreatorId(creatorId);
    ticket.setStatus(status);

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
}