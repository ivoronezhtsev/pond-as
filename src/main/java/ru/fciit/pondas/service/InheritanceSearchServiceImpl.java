package ru.fciit.pondas.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.fciit.pondas.model.InheritanceSearchRequest;
import ru.fciit.pondas.model.InheritanceSearchResponse;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class InheritanceSearchServiceImpl implements InheritanceSearchService {

    private final String inheritanceSearchUrl;
    private final RestTemplate restTemplate;

    public InheritanceSearchServiceImpl(@Value("${inheritance.search.url}") String inheritanceSearchUrl,
                                        RestTemplate restTemplate) {
        this.inheritanceSearchUrl = inheritanceSearchUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public InheritanceSearchResponse find(InheritanceSearchRequest inheritanceSearchRequest) throws JsonProcessingException, URISyntaxException {
        val headers = new org.springframework.http.HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        String requestJson = new ObjectMapper().writeValueAsString(inheritanceSearchRequest);
        headers.set("Content-Length", String.valueOf(requestJson.length()));
        headers.set("Host", new URI(inheritanceSearchUrl).getHost());
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(requestJson, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(inheritanceSearchUrl, httpEntity, String.class);
        return new ObjectMapper().readValue(response.getBody(), InheritanceSearchResponse.class);
    }
}
