package ru.fciit.pondas.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.fciit.pondas.model.InheritanceSearchRequest;
import ru.fciit.pondas.model.InheritanceSearchResponse;

import java.net.URISyntaxException;

public interface InheritanceSearchService {

    InheritanceSearchResponse find(InheritanceSearchRequest request) throws JsonProcessingException, URISyntaxException;
}