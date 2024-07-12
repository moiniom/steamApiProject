package org.example.steamapiproject;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.steamapiproject.ownedresponse.GameRecord;

import java.io.IOException;
import java.net.URL;

public class Game {
    private final HBox root = new HBox();
    private Label name;
    private Label playtimeAll;
    private Label playtimeWin;
    private Label playtimeLin;
    private Label playtimeMac;
    private Label playtimeDec;
    private Image image;
    private final GameRecord gameRecord;

    private final int gameId;

    public Game(GameRecord gameRecord) {
        this.gameRecord = gameRecord;
        gameId = this.gameRecord.gameid();
        buildGUI();
    }

    private void buildGUI() {
        name = new Label(gameRecord.name());
        playtimeAll = new Label(String.valueOf(gameRecord.totalPlaytime()));
        playtimeWin = new Label(String.valueOf(gameRecord.windowsPlaytime()));
        playtimeLin = new Label(String.valueOf(gameRecord.linuxPlaytime()));
        playtimeMac = new Label(String.valueOf(gameRecord.macPlaytime()));
        playtimeDec = new Label(String.valueOf(gameRecord.steamDeckPlaytime()));
        try {
            image = new Image(new URL(
                    "http://media.steampowered.com/steamcommunity/public/images/apps/"+gameId+"/"+gameRecord.iconUrl()+".jpg"
            ).openConnection().getInputStream());
        } catch (IOException e) {
            image = new Image("src/main/resources/org/example/steamapiproject/error.jpg");
        }

        root.getChildren().addAll(
                new ImageView(image),
                new VBox(
                        name,
                        new VBox(
                                new HBox(
                                        new Label("All: "),
                                        playtimeAll
                                ),
                                new HBox(
                                        new Label("Win: "),
                                        playtimeWin
                                ),
                                new HBox(
                                        new Label("Lin: "),
                                        playtimeLin
                                ),
                                new HBox(
                                        new Label("Mac: "),
                                        playtimeMac
                                ),
                                new HBox(
                                        new Label("Deck: "),
                                        playtimeDec
                                )
                        )
                )
        );
    }

    public HBox getGUI() {
        return root;
    }

    public int getGameId() {
        return gameId;
    }
}
