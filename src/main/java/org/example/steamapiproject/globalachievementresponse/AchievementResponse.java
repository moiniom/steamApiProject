package org.example.steamapiproject.globalachievementresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AchievementResponse(AchievementPercentages achievementPercentages) {
    public AchievementResponse(
            @JsonProperty("achievementpercentages") AchievementPercentages achievementPercentages
    ) {
        this.achievementPercentages = achievementPercentages;
    }
}
