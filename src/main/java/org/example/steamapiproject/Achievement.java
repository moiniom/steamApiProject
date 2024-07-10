package org.example.steamapiproject;

public class Achievement {
    private String name;
    private int defaultvalue;
    private String displayname;
    private boolean hidden;
    private String description;
    private String icon;
    private String icongray;

    public Achievement(
            String name,
            int defaultvalue,
            String displayname,
            int hidden,
            String description,
            String icon,
            String icongray
            ) {
        this.name = name;
        this.defaultvalue = defaultvalue;
        this.displayname = displayname;
        this.hidden = hidden > 0;
        this.description = description;
        this.icon = icon;
        this.icongray = icongray;
    }
}
