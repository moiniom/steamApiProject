package org.example.steamapiproject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameSchema {
    public String name;
    public int version;
    public GameStats gameStats;

    public GameSchema(
            @JsonProperty("gameName") String name,
            @JsonProperty("gameVersion") int version,
            @JsonProperty("availableGameStats") GameStats availibleGameStats) {
        this.name = name;
        this.version = version;
        this.gameStats = availibleGameStats;
    }

    public String getName() {
        return name;
    }

    public int getVersion() {
        return version;
    }

    public GameStats getGameStats() {
        return gameStats;
    }
}
