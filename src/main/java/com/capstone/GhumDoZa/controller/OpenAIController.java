package com.capstone.GhumDoZa.controller;

import com.capstone.GhumDoZa.dto.Message;
import com.capstone.GhumDoZa.dto.OpenAIRequest;
import com.capstone.GhumDoZa.dto.OpenAIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/bot")
public class OpenAIController {
    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){
        Message userMessage = new Message("user", prompt);

        List<Message> messages = List.of(userMessage);
        OpenAIRequest request = new OpenAIRequest(model, messages);

        OpenAIResponse openAIResponse = template.postForObject(apiURL, request, OpenAIResponse.class);
        assert openAIResponse != null;
        return openAIResponse.getChoices().get(0).getMessage().getContent();
    }
}
