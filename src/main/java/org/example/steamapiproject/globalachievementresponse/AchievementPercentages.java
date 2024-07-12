package org.example.steamapiproject.globalachievementresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AchievementPercentages(List<GlobalAchievement> globalAchievements) {
    public AchievementPercentages(
            @JsonProperty("achievements") List<GlobalAchievement> globalAchievements
    ) {
        this.globalAchievements = globalAchievements;
    }
}
