package org.example.steamapiproject.globalachievementresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Achievement(String name, float percent) {
    public Achievement(
            @JsonProperty("name") String name,
            @JsonProperty("percent") float percent
    ) {
        this.name = name;
        this.percent = percent;
    }
}
