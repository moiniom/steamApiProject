package org.example.steamapiproject.playerachivementresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PlayerAchievements(String steamId, String name, List<Achievement> achievements, boolean wasSuccessful) {
    public PlayerAchievements(
            @JsonProperty("steamID") String steamId,
            @JsonProperty("gameName") String name,
            @JsonProperty("achievements") List<Achievement> achievements,
            @JsonProperty("success") boolean wasSuccessful
    ) {
        this.steamId = steamId;
        this.name = name;
        this.achievements = achievements;
        this.wasSuccessful = wasSuccessful;
    }
}
