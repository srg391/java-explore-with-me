package ru.practium.client;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletRequest;

public interface StatisticsClient {
    void createEndpointHit(HttpServletRequest request) throws JsonProcessingException;
}
