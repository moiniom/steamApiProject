package org.example.steamapiproject;

import java.util.ArrayList;
import java.util.List;

public class GameSchema {
    private String name;
    private int version;
    private List<Achievement> achievements;

    public GameSchema(String name, int version, List<Achievement> achievements) {
        this.name = name;
        this.version = version;
        this.achievements = achievements;
    }
}
