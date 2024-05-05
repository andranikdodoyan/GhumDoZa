package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.dto.comment.CommentListDto;
import com.capstone.GhumDoZa.service.CommentService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/comment")
public class CommentController {

  private final CommentService commentService;

  @GetMapping("/list/{ticketId}")
  public ResponseEntity<CommentListDto> getCommentsOfTicket(@PathVariable UUID ticketId) {
    return ResponseEntity.ok(commentService.getCommentsOfTicket(ticketId));
  }
}
