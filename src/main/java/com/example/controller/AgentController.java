package com.example.controller;

import com.example.dto.ApiResponse;
import com.example.model.AgentRequest;
import com.example.model.AgentResponse;
import com.example.service.AgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/send-massage")
    public ResponseEntity<ApiResponse> forwardNumber(@RequestBody AgentRequest request) {
        AgentResponse agentResponse = agentService.forwardRequest(request);

        if (agentResponse != null) {
            ApiResponse apiResponse = new ApiResponse(agentResponse.isSE(), agentResponse.getAbnormalType());
            return ResponseEntity.ok(apiResponse);
        } else {
            return ResponseEntity.status(500).body(new ApiResponse(false, "Error processing request"));
        }
    }
}
