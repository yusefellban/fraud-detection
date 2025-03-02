package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AgentResponse {
    @JsonProperty("is_SE")
    private boolean isSE;
    @JsonProperty("abnormal_type")
    private String abnormalType;

    public AgentResponse(boolean isSE, String abnormalType) {
        this.isSE = isSE;
        this.abnormalType = abnormalType;
    }

    public boolean isSE() {
        return isSE;
    }

    public void setSE(boolean SE) {
        isSE = SE;
    }

    public String getAbnormalType() {
        return abnormalType;
    }

    public void setAbnormalType(String abnormalType) {
        this.abnormalType = abnormalType;
    }
}

