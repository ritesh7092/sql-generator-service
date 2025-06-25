package com.Arth.sql_generator_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

import java.time.Duration;

@Configuration
public class OllamaConfig {

    @Value("${ollama.base-url:http://localhost:11434")
    private String ollamaBaseUrl;

    @Value("${ollama.timeout:30}")
    private int timeoutSeconds;

    @Bean
    public WebClient ollamaWebClient(){
        return WebClient.builder()
       .baseUrl(ollamaBaseUrl)
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(1024 * 1024)) // 1MB
                .defaultHeaders(headers -> {
                    headers.add("Content-Type", "application/json");
                    headers.add("Accept", "application/json");
                })
                .build();
    }

    @Bean
    public Retry ollamaRetrySpec() {
        return Retry.backoff(2, Duration.ofSeconds(1))
                .maxBackoff(Duration.ofSeconds(5))
                .filter(throwable -> !(throwable instanceof IllegalArgumentException));
    }

}
