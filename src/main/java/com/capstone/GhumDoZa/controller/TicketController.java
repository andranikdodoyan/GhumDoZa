package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.dto.ticket.TicketDto;
import com.capstone.GhumDoZa.dto.ticket.TicketListDto;
import com.capstone.GhumDoZa.service.TicketService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

  @PostMapping("/update")
  public ResponseEntity<TicketDto> updateTicket(
      @RequestBody final TicketDto ticketDto) {
    return ResponseEntity.ok(ticketService.updateStatus(ticketDto));
  }

  @GetMapping("/list/{userId}")
  public ResponseEntity<TicketListDto> getTicketsOfUser(@PathVariable UUID userId) {
    return ResponseEntity.ok(ticketService.getTicketsOfUser(userId));
  }
}
