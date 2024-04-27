package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/ticket")
public class TicketController {

  private final TicketService ticketService;

}
