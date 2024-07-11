package org.example.steamapiproject.schemaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SchemaResponse(GameSchema game) {
    public SchemaResponse(
            @JsonProperty("game") GameSchema game
    ) {
        this.game = game;
    }
}
