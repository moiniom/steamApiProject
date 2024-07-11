package org.example.steamapiproject.playerachivementresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PlayerResponse(PlayerAchievements playerAchievements) {
    public PlayerResponse(
            @JsonProperty("playerstats") PlayerAchievements playerAchievements
    ) {
        this.playerAchievements = playerAchievements;
    }
}
