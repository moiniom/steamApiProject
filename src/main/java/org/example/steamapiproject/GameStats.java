package org.example.steamapiproject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GameStats {
    public List<Achievement> achievements;
    public List<Stat> stats;

    public GameStats(
            @JsonProperty("achievements") List<Achievement> achievements,
            @JsonProperty("stats")List<Stat> stats
    ) {
        this.achievements = achievements;
        this.stats = stats;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public List<Stat> getStats() {
        return stats;
    }
}
