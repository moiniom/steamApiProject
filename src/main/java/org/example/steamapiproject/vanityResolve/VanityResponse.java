package org.example.steamapiproject.vanityResolve;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VanityResponse(VanityResponseBody responseBody) {
    public VanityResponse(
            @JsonProperty("response") VanityResponseBody responseBody
    ) {
        this.responseBody = responseBody;
    }
}
