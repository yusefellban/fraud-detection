package com.example.model;

public class AgentRequest {
    private String message;

    public AgentRequest(String message) {
        this.message = message;
    }
public AgentRequest() {}
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
