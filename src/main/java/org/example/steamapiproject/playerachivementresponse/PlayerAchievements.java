package org.example.steamapiproject.playerachivementresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PlayerAchievements(String steamId, String name, List<PlayerAchievement> playerAchievements, boolean wasSuccessful) {
    public PlayerAchievements(
            @JsonProperty("steamID") String steamId,
            @JsonProperty("gameName") String name,
            @JsonProperty("achievements") List<PlayerAchievement> playerAchievements,
            @JsonProperty("success") boolean wasSuccessful
    ) {
        this.steamId = steamId;
        this.name = name;
        this.playerAchievements = playerAchievements;
        this.wasSuccessful = wasSuccessful;
    }
}
