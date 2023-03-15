package ru.practicum;

import ru.practicum.dto.EndpointHitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.dto.GetStatsDto;
import ru.practicum.model.EndpointHit;
import ru.practicum.model.EndpointHitMapper;
import ru.practicum.model.ViewStats;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private static String PREFORMATTED;

    private final StatsRepository statsRepository;

    private final EndpointHitMapper endpointHitMapper;

    @Override
    public List<ViewStats> getStats(GetStatsDto getStatsDto) {
        LocalDateTime startTime = LocalDateTime.parse(getStatsDto.getStart(), DateTimeFormatter.ofPattern(PREFORMATTED));
        LocalDateTime endTime = LocalDateTime.parse(getStatsDto.getEnd(), DateTimeFormatter.ofPattern(PREFORMATTED));
            return (getStatsDto.getUnique()) ? statsRepository.findAllUnique(startTime, endTime, getStatsDto.getUris(), true) :
                    statsRepository.findAll(startTime, endTime, getStatsDto.getUris());
    }

    @Override
    public EndpointHitDto createHit(EndpointHitDto endpointHitDto) {
        EndpointHit hit = new EndpointHit(null, endpointHitDto.getApp(), endpointHitDto.getUri(),
                endpointHitDto.getIp(), endpointHitDto.getTimestamp());
        EndpointHit savedHit = statsRepository.save(hit);
        return endpointHitMapper.createEndpointHitDto(savedHit);
    }

}
