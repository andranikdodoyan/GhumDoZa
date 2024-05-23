package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.dto.openai.Message;
import com.capstone.GhumDoZa.dto.openai.OpenAIRequest;
import com.capstone.GhumDoZa.dto.openai.OpenAIResponse;
import com.capstone.GhumDoZa.dto.ticket.TicketListDto;
import com.capstone.GhumDoZa.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/openai")
public class OpenAIController {

    private static final Logger logger = LoggerFactory.getLogger(OpenAIController.class);

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiURL;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/grammar")
    public String checkGrammar(@RequestParam("text") String text){
        String prompt = "Please check and correct the grammar of the following text, and return the corrected version," 
            + "If the text has no meaning or mistake do not change it and return it as it is. "
            + "Return only the text, no need to wrap your answer with human-like phrases : " + text;
        Message userMessage = new Message("user", prompt);

        List<Message> messages = List.of(userMessage);
        OpenAIRequest request = new OpenAIRequest(model, messages);

        try {
            OpenAIResponse response = restTemplate.postForObject(apiURL, request, OpenAIResponse.class);
            if (response != null && !response.getChoices().isEmpty()) {
                return response.getChoices().get(0).getMessage().getContent();
            } else {
                logger.error("Invalid response from OpenAI API");
                return "There was an error processing your request.";
            }
        } catch (Exception e) {
            logger.error("Error during API call: ", e);
            return "An error occurred while processing your request.";
        }
    }

    @GetMapping("/task")
    public String enhanceTask(@RequestParam("text") String text){
        String prompt = "This is the task description which we currently have, given all the information that you have suggest a better way of formulating given task so that the requirements a more well defined and the problem and goal are well defined. So, give overall better task description. Here is it: " + text;
        Message userMessage = new Message("user", prompt);

        List<Message> messages = List.of(userMessage);
        OpenAIRequest request = new OpenAIRequest(model, messages);

        try {
            OpenAIResponse response = restTemplate.postForObject(apiURL, request, OpenAIResponse.class);
            if (response != null && !response.getChoices().isEmpty()) {
                return response.getChoices().get(0).getMessage().getContent();
            } else {
                logger.error("Invalid response from OpenAI API");
                return "There was an error processing your request.";
            }
        } catch (Exception e) {
            logger.error("Error during API call: ", e);
            return "An error occurred while processing your request.";
        }
    }

    @GetMapping("/search")
    public ResponseEntity<TicketListDto> searchTickets(@RequestParam("text") String text) throws Exception {
        String prompt = "Extract the main keywords or intent from the following search query: " + text;
        Message userMessage = new Message("user", prompt);

        List<Message> messages = List.of(userMessage);
        OpenAIRequest request = new OpenAIRequest(model, messages);

        try {
            OpenAIResponse response = restTemplate.postForObject(apiURL, request, OpenAIResponse.class);
            if (response != null && !response.getChoices().isEmpty()) {
                String extractedKeywords = response.getChoices().get(0).getMessage().getContent();
                return ResponseEntity.ok(ticketService.searchTicketsByKeywords(extractedKeywords));
            } else {
                logger.error("Invalid response from OpenAI API");
                throw new Exception();
            }
        } catch (Exception e) {
            logger.error("Error during API call: ", e);
            throw e;        }
    }
}
