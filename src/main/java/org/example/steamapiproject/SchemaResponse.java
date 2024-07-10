package org.example.steamapiproject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SchemaResponse {
    public GameSchema game;

    public SchemaResponse(
            @JsonProperty("game") GameSchema game
    ) {
        this.game = game;
    }
}
