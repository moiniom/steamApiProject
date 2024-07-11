package org.example.steamapiproject.globalachievementresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AchievementPercentages(List<Achievement> achievements) {
    public AchievementPercentages(
            @JsonProperty("achievements") List<Achievement> achievements
    ) {
        this.achievements = achievements;
    }
}
