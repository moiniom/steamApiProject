package org.example.steamapiproject.schemaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SchemaAchievement(String name, boolean defaultValue, String displayName, boolean hidden, String description,
                                String icon, String iconGray) {
    public SchemaAchievement(
            @JsonProperty("name") String name,
            @JsonProperty("defaultvalue") boolean defaultValue,
            @JsonProperty("displayName") String displayName,
            @JsonProperty("hidden") boolean hidden,
            @JsonProperty("description") String description,
            @JsonProperty("icon") String icon,
            @JsonProperty("icongray") String iconGray
    ) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.displayName = displayName;
        this.hidden = hidden;
        this.description = description;
        this.icon = icon;
        this.iconGray = iconGray;
    }
}
