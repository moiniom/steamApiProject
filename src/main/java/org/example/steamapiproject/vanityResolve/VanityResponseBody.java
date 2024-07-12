package org.example.steamapiproject.vanityResolve;

import com.fasterxml.jackson.annotation.JacksonInject;

public record VanityResponseBody(String steamId, boolean success) {
    public VanityResponseBody(
            @JacksonInject("steamid") String steamId,
            @JacksonInject("success") boolean success) {
        this.steamId = steamId;
        this.success = success;
    }
}
