package ru.practicum;

import ru.practicum.dto.EndpointHitDto;
import ru.practicum.dto.GetStatsDto;
import ru.practicum.model.ViewStats;

import java.util.List;

public interface StatsService {

    List<ViewStats> getStats(GetStatsDto getStatsDto);

    EndpointHitDto createHit(EndpointHitDto endpointHitDto);

}
