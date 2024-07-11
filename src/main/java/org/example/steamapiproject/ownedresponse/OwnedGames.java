package org.example.steamapiproject.ownedresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record OwnedGames(int gamecount, List<Game> games) {
    public OwnedGames(
            @JsonProperty("game_count") int gamecount,
            @JsonProperty("games") List<Game> games) {
        this.gamecount = gamecount;
        this.games = games;
    }
}
