package ru.practicum;

import ru.practicum.dto.EndpointHitDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.dto.GetStatsDto;
import ru.practicum.model.GetStatsMapper;
import ru.practicum.model.ViewStats;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
public class StatsController {

    private final GetStatsMapper getStatsMapper;

    private final StatsService statsService;

    @GetMapping("/stats")
    public List<ViewStats> getStats(@RequestParam(name = "start") String start,
                                    @RequestParam(name = "end") String end,
                                    @RequestParam(name = "uris", required = false) List<String> uris,
                                    @RequestParam(name = "unique", defaultValue = "false") boolean unique) {
        log.info("Статистика посещения по параметрам: start = " + start +
                ", end = " + end + ", uris size = " + uris.size() + "unique =" + unique);
        GetStatsDto getStatsDto = getStatsMapper.createDtoItem(start, end, uris, unique);
        return statsService.getStats(getStatsDto);
    }

    @PostMapping("/hit")
    public void createHit(@RequestBody @Valid EndpointHitDto endpointHitDto) {
        log.info("Создана информация о запросе к сервису: " + endpointHitDto);
        statsService.createHit(endpointHitDto);
    }

}
