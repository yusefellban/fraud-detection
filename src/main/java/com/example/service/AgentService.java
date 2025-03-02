package com.example.service;

import com.example.model.AgentRequest;
import com.example.model.AgentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AgentService {

    private final RestTemplate restTemplate;
    private static final String FLASK_API_URL = "http://10.10.8.243:5000/process-message";

    public AgentService() {
        this.restTemplate = new RestTemplate();
    }

    public AgentResponse forwardRequest(AgentRequest request) {
        ResponseEntity<AgentResponse> response = restTemplate.postForEntity(FLASK_API_URL, request, AgentResponse.class);
        return response.getBody();
    }
}
