package ru.practicum.model;

import org.springframework.stereotype.Component;
import ru.practicum.dto.EndpointHitDto;

@Component
public class EndpointHitMapper {
    public EndpointHitDto createEndpointHitDto(EndpointHit endpointHit) {
        return new EndpointHitDto(
                endpointHit.getApp(), endpointHit.getUri(), endpointHit.getIp(), endpointHit.getTimestamp()
        );
    }

}
