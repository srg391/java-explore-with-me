package ru.practicum.model;

import org.springframework.stereotype.Component;
import ru.practicum.dto.GetStatsDto;

import java.util.List;

@Component
public class GetStatsMapper {

    public GetStatsDto createDtoItem(String start, String end, List<String> uris, boolean unique) {
        return new GetStatsDto(
                start,
                end,
                uris,
                unique
        );
    }
}
