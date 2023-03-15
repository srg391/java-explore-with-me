package ru.practicum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.model.EndpointHit;
import ru.practicum.model.ViewStats;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsRepository extends JpaRepository<EndpointHit, Long> {

    @Query("SELECT new ru.practicum.model.ViewStats(e.app, e.uri, COUNT (DISTINCT e.ip)) from EndpointHit e WHERE e.timestamp> ?1 AND e.timestamp< ?2 GROUP BY e.app, e.uri ORDER BY COUNT (e.ip) DESC")
    List<ViewStats> findAllUnique(LocalDateTime startCod, LocalDateTime endCod, List<String> uris, boolean unique);

    @Query("SELECT new ru.practicum.model.ViewStats(e.app, e.uri, COUNT (e.ip)) from EndpointHit e WHERE e.timestamp> ?1 AND e.timestamp< ?2 GROUP BY e.app, e.uri ORDER BY COUNT (e.ip) DESC")
    List<ViewStats> findAll(LocalDateTime start, LocalDateTime end, List<String> uris);
}
