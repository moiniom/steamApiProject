package org.example.steamapiproject.schemaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GameStats(List<SchemaAchievement> schemaAchievements, List<Stat> stats) {
    public GameStats(
            @JsonProperty("achievements") List<SchemaAchievement> schemaAchievements,
            @JsonProperty("stats") List<Stat> stats
    ) {
        this.schemaAchievements = schemaAchievements;
        this.stats = stats;
    }
}
