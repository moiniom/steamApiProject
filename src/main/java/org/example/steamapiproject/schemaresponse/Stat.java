package org.example.steamapiproject.schemaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Stat(String name, int defaultValue, String displayName) {
    public Stat(
            @JsonProperty("name") String name,
            @JsonProperty("defaultvalue") int defaultValue,
            @JsonProperty("displayName") String displayName) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.displayName = displayName;
    }
}
