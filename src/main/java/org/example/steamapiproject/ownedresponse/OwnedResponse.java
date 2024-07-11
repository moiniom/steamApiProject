package org.example.steamapiproject.ownedresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OwnedResponse(OwnedGames ownedGames) {
    public OwnedResponse(
            @JsonProperty("response") OwnedGames ownedGames
    ) {
        this.ownedGames = ownedGames;
    }
}
