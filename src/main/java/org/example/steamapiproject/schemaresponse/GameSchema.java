package org.example.steamapiproject.schemaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GameSchema(String name, int version, GameStats gameStats) {
    public GameSchema(
            @JsonProperty("gameName") String name,
            @JsonProperty("gameVersion") int version,
            @JsonProperty("availableGameStats") GameStats gameStats
    ) {
        this.name = name;
        this.version = version;
        this.gameStats = gameStats;
    }
}
