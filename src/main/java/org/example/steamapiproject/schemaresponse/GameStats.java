package org.example.steamapiproject.schemaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GameStats(List<Achievement> achievements, List<Stat> stats) {
    public GameStats(
            @JsonProperty("achievements") List<Achievement> achievements,
            @JsonProperty("stats") List<Stat> stats
    ) {
        this.achievements = achievements;
        this.stats = stats;
    }
}
