package org.example.steamapiproject.globalachievementresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GlobalAchievement(String name, float percent) {
    public GlobalAchievement(
            @JsonProperty("name") String name,
            @JsonProperty("percent") float percent
    ) {
        this.name = name;
        this.percent = percent;
    }
}
