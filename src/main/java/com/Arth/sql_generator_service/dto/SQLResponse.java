package com.Arth.sql_generator_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SQLResponse {

    @JsonProperty("sql_query")
    private String sqlQuery;

    private String explanation;

    private double confidence;

    @JsonProperty("generated_at")
    private LocalDateTime generatedAt;

    private List<String> warnings;

    public SQLResponse(String sqlQuery, String explanation, double confidence){
        this();
        this.sqlQuery = sqlQuery;
        this.explanation = explanation;
        this.confidence = confidence;
    }
}

