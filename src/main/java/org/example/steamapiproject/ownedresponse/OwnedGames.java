package org.example.steamapiproject.ownedresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record OwnedGames(int gamecount, List<GameRecord> gameRecords) {
    public OwnedGames(
            @JsonProperty("game_count") int gamecount,
            @JsonProperty("games") List<GameRecord> gameRecords) {
        this.gamecount = gamecount;
        this.gameRecords = gameRecords;
    }
}
