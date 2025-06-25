package com.Arth.sql_generator_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SQLRequest {

    @NotBlank(message = "Query description is required")
    @Size(max = 1000, message = "Query description must be less than 1000 characters")
    @JsonProperty("query_description")
    private String queryDescription;

    @JsonProperty("database_schema")
    private String databaseSchema;

    @JsonProperty("database_type")
    private String databaseType = "postgresql";

    @JsonProperty("table_names")
    private List<String> tableNames;


    public SQLRequest(String queryDescription) {
        this.queryDescription = queryDescription;
    }

}
