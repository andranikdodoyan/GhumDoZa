package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.dto.openai.Message;
import com.capstone.GhumDoZa.dto.openai.OpenAIRequest;
import com.capstone.GhumDoZa.dto.openai.OpenAIResponse;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/grammar")
    public String checkGrammar(@RequestParam("text") String text){
        String prompt = "Please check and correct the grammar of the following text, and return the corrected version: " + text;
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
}
