package org.example.steamapiproject.playerachivementresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Achievement(String name, boolean achieved, int unlockTime) {
    public Achievement(
            @JsonProperty("apiname") String name,
            @JsonProperty("achieved") boolean achieved,
            @JsonProperty("unlocktime") int unlockTime
    ) {
        this.name = name;
        this.achieved = achieved;
        this.unlockTime = unlockTime;
    }
}
