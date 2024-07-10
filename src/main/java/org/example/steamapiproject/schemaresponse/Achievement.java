package org.example.steamapiproject.schemaresponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Achievement {
    public String name;
    public int defaultValue;
    public String displayName;
    public boolean hidden;
    public String description;
    public String icon;
    public String iconGray;

    public Achievement(
            @JsonProperty("name") String name,
            @JsonProperty("defaultvalue") int defaultValue,
            @JsonProperty("displayName") String displayName,
            @JsonProperty("hidden") int hidden,
            @JsonProperty("description") String description,
            @JsonProperty("icon") String icon,
            @JsonProperty("icongray") String iconGray
            ) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.displayName = displayName;
        this.hidden = hidden > 0;
        this.description = description;
        this.icon = icon;
        this.iconGray = iconGray;
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

    public boolean isHidden() {
        return hidden;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getIconGray() {
        return iconGray;
    }
}
