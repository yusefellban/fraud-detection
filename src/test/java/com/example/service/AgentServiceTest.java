package com.example.service;

import com.example.controller.AgentController;
import com.example.dto.ApiResponse;
import com.example.model.AgentRequest;
import com.example.model.AgentResponse;
import com.example.service.AgentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AgentControllerTest {

    @Mock
    private AgentService agentService;

    @InjectMocks
    private AgentController agentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void forwardNumber_ShouldReturnSuccessResponse_WhenAgentResponseIsNotNull() {
        // Arrange
        AgentRequest request = new AgentRequest(); // Assume appropriate constructor or setters exist
        AgentResponse mockResponse = new AgentResponse(true, "Valid response");
        when(agentService.forwardRequest(request)).thenReturn(mockResponse);

        // Act
        ResponseEntity<ApiResponse> responseEntity = agentController.forwardNumber(request);

        // Assert
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody().isStatus());
        assertEquals("Valid response", responseEntity.getBody().getMessage());
    }

    @Test
    void forwardNumber_ShouldReturnErrorResponse_WhenAgentResponseIsNull() {
        // Arrange
        AgentRequest request = new AgentRequest();
        when(agentService.forwardRequest(request)).thenReturn(null);

        // Act
        ResponseEntity<ApiResponse> responseEntity = agentController.forwardNumber(request);

        // Assert
        assertEquals(500, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertFalse(responseEntity.getBody().isStatus());
        assertEquals("Error processing request", responseEntity.getBody().getMessage());
    }
}
