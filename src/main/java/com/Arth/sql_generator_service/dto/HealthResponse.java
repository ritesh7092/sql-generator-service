package com.Arth.sql_generator_service.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthResponse {

    private String status;

    @JsonProperty("llm_available")
    private boolean llmAvailable;

    private String model;

    private Map<String, Object> systemMemoryUsage;

    public HealthResponse(String status, boolean llmAvailable, String model) {
        this.status = status;
        this.llmAvailable = llmAvailable;
        this.model = model;
    }
}
