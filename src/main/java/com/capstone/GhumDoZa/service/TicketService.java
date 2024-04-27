package com.capstone.GhumDoZa.service;

import com.capstone.GhumDoZa.entity.UserEntity;
import com.capstone.GhumDoZa.repository.TicketRepository;
import com.capstone.GhumDoZa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {

  private final TicketRepository ticketRepository;

}