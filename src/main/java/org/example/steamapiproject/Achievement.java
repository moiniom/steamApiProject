package org.example.steamapiproject;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.steamapiproject.globalachievementresponse.GlobalAchievement;
import org.example.steamapiproject.playerachivementresponse.PlayerAchievement;
import org.example.steamapiproject.schemaresponse.SchemaAchievement;

import java.io.IOException;
import java.net.URL;

public class Achievement {
    private final HBox root = new HBox();
    private Label name;
    private Label description;
    private Image icon;
    private Label percentage;

    private final PlayerAchievement playerAchievement;
    private final GlobalAchievement globalAchievement;
    private final String id;
    private final boolean unlocked;
    private final SchemaAchievement schemaAchievement;

    public Achievement(
            SchemaAchievement schemaAchievement,
            GlobalAchievement globalAchievement,
            PlayerAchievement playerAchievement
    ) throws IOException {
        this.playerAchievement = playerAchievement;
        this.globalAchievement = globalAchievement;
        this.schemaAchievement = schemaAchievement;
        id = schemaAchievement.name();
        unlocked = playerAchievement.achieved();

        buildGUI();
    }

    private void buildGUI() throws IOException {

        name = new Label(schemaAchievement.displayName());
        description = new Label(schemaAchievement.description());
        percentage = new Label(String.valueOf(globalAchievement.percent()));

        if (unlocked) {
            icon = new Image(new URL(schemaAchievement.icon()).openConnection().getInputStream());
        } else {
            icon = new Image(new URL(schemaAchievement.iconGray()).openConnection().getInputStream());
        }

        root.getChildren().addAll(
                new ImageView(icon),
                new VBox(
                        name,
                        new HBox(
                                description,
                                new VBox(
                                        new Label("Unlocked"),
                                        new Label(String.valueOf(unlocked))
                                ),
                                new VBox(
                                        new Label("Global%"),
                                        percentage
                                )
                        )
                )
        );
    }

    public HBox getGUI() {
        return root;
    }
}
