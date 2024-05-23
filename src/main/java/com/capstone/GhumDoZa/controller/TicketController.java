package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.dto.ticket.TicketCreateRequestDto;
import com.capstone.GhumDoZa.dto.ticket.TicketDto;
import com.capstone.GhumDoZa.dto.ticket.TicketListDto;
import com.capstone.GhumDoZa.service.TicketService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/ticket")
public class TicketController {

  private final TicketService ticketService;
  @GetMapping("/{ticketId}")
  public ResponseEntity<TicketDto> getTicketById(@PathVariable UUID ticketId) {
    return ResponseEntity.ok(ticketService.getTicket(ticketId));
  }
  @PostMapping("/create")
  public ResponseEntity<TicketDto> createTicket(
      @RequestBody final TicketCreateRequestDto ticketCreateRequestDto) {
    return ResponseEntity.ok(ticketService.createTicket(ticketCreateRequestDto));
  }

  @GetMapping("/list/{userId}")
  public ResponseEntity<TicketListDto> getTicketsOfUser(@PathVariable UUID userId) {
    return ResponseEntity.ok(ticketService.getTicketsOfUser(userId));
  }

  @GetMapping("/list/project/{projectId}")
  public ResponseEntity<TicketListDto> getTicketsOfProject(@PathVariable UUID projectId) {
    return ResponseEntity.ok(ticketService.getTicketsOfProject(projectId));
  }

  @DeleteMapping("delete/{ticketId}")
  public ResponseEntity<Boolean> deleteTicket(@PathVariable UUID ticketId) {
    return ResponseEntity.ok(ticketService.deleteTicket(ticketId));
  }

  @PostMapping("/update")
  public ResponseEntity<TicketDto> updateTicket(
      @RequestBody final TicketDto ticketDto) {
    return ResponseEntity.ok(ticketService.updateTicket(ticketDto));
  }




}
