package org.example.steamapiproject.vanityResolve;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VanityResponseBody(String steamId, boolean success) {
    public VanityResponseBody(
            @JsonProperty("steamid") String steamId,
            @JsonProperty("success") boolean success) {
        this.steamId = steamId;
        this.success = success;
    }
}
