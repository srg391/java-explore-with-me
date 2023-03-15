package ru.practicum.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.practicum.dto.EndpointHitDto;

@Component
@AllArgsConstructor
public class EndpointHitMapper {
    public EndpointHitDto createEndpointHitDto(EndpointHit endpointHit) {
        return new EndpointHitDto(
                endpointHit.getApp(),
                endpointHit.getUri(),
                endpointHit.getIp(),
                endpointHit.getTimestamp()
        );
    }

}
