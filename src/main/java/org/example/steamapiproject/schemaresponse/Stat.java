package org.example.steamapiproject.schemaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stat {
    public String name;
    public int defaultValue;
    public String displayName;

    public Stat(
            @JsonProperty("name") String name,
            @JsonProperty("defaultvalue") int defaultValue,
            @JsonProperty("displayName") String displayName) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.displayName = displayName;
    }

    public String getName() {
        return name;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    public String getDisplayName() {
        return displayName;
    }
}
