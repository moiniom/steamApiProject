package org.example.steamapiproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.steamapiproject.globalachievementresponse.AchievementResponse;
import org.example.steamapiproject.globalachievementresponse.GlobalAchievement;
import org.example.steamapiproject.ownedresponse.GameRecord;
import org.example.steamapiproject.ownedresponse.OwnedResponse;
import org.example.steamapiproject.playerachivementresponse.PlayerAchievement;
import org.example.steamapiproject.playerachivementresponse.PlayerResponse;
import org.example.steamapiproject.schemaresponse.SchemaAchievement;
import org.example.steamapiproject.schemaresponse.SchemaResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Main extends Application{
    private final SteamAPI api = new SteamAPI();
    private String steamId = "";

    private final List<Game> games = new ArrayList<>();

    private final MenuItem exitItem = new MenuItem("Exit");
    private final MenuItem settingApiKey = new MenuItem("Change API Key");
    private final Menu fileMenu = new Menu("File");
    private final Menu settingsMenu = new Menu("Settings");
    private final MenuBar menuBar = new MenuBar(fileMenu, settingsMenu);
    private final TextField steamIdField = new TextField();
    private final Button steamIdButton = new Button("Enter");
    private final VBox gameBox = new VBox();
    private final VBox achievements = new VBox();

    TextArea errormessage = new TextArea();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        steamIdField.setPromptText("Enter SteamID");

        ScrollPane achievementScroll = new ScrollPane(achievements);
        ScrollPane gameScroll = new ScrollPane(gameBox);

        HBox idBox = new HBox(
                steamIdField,
                steamIdButton
        );

        VBox gamesBox = new VBox(
                new Label("Games"),
                gameScroll
        );

        VBox achievementBox = new VBox(
                new Label("Achievements"),
                achievementScroll
        );

        HBox displayBox = new HBox(
                gamesBox,
                achievementBox
        );

        VBox root =  new VBox(
                menuBar,
                idBox,
                displayBox
        );


        fileMenu.getItems().addAll(exitItem);
        settingsMenu.getItems().addAll(settingApiKey);

        exitItem.setOnAction(event -> stage.close());
        settingApiKey.setOnAction(event -> setKeyWin());

        steamIdButton.setOnAction(event -> setSteamId());


        stage.setTitle("Steam API");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    private void setKeyWin() {
        Stage stage = new Stage();
        VBox root = new VBox();
        Label label = new Label("Enter API Key");
        TextField keyField = new TextField();
        Button enterKey = new Button("Enter");

        root.getChildren().addAll(
                label,
                keyField,
                enterKey
        );

        enterKey.setOnAction(event -> setKey(keyField));

        stage.setTitle("Set API Key");
        stage.setScene(new Scene(root, 200, 100));
        stage.show();
    }

    private void setKey(TextField keyField) {
        api.setKey(keyField.getText().toUpperCase().strip());
        Stage stage = (Stage) keyField.getScene().getWindow();
        stage.close();
    }

    private void setSteamId() {
        steamId = steamIdField.getText().toUpperCase().strip();
        updateGames();
    }

    private void updateGames() {
        gameBox.getChildren().clear();
        try {
            OwnedResponse response = api.getOwnedGames(steamId);
            for (GameRecord gameRecord : response.ownedGames().gameRecords()) {
                Game game = new Game(gameRecord);
                gameBox.getChildren().add(game.getGUI());
                game.getGUI().setOnMouseClicked(event -> loadAchievements(game));
                games.add(game);
            }
        } catch (IOException e) {
            gameBox.getChildren().add(new Label("Connection error"));
            errormessage.setText(e.toString());
        }
    }

    private void loadAchievements(Game game) {
        achievements.getChildren().clear();
        try {
            SchemaResponse schemaResponse = api.getGameSchema(game.getGameId());
            AchievementResponse globalResponse = api.getAchievementStats(game.getGameId());
            PlayerResponse playerResponse = api.getPlayerAchievements(steamId, game.getGameId());

            if (schemaResponse == null || globalResponse == null || playerResponse == null) {
                achievements.getChildren().add(
                        new Label("Game doesn't have achievements")
                );
                return;
            }

            List<SchemaAchievement> schemaAchievements = schemaResponse.game().gameStats().schemaAchievements();
            List<GlobalAchievement> globalAchievements = globalResponse.achievementPercentages().globalAchievements();
            List<PlayerAchievement> playerAchievements = playerResponse.playerAchievements().playerAchievements();

            for(SchemaAchievement schemaAchievement : schemaAchievements) {
                List<Object> achievementParams = new ArrayList<>();
                achievementParams.add(schemaAchievement);
                for (GlobalAchievement globalAchievement : globalAchievements) {
                    if (Objects.equals(globalAchievement.name(), schemaAchievement.name())) {
                        achievementParams.add(globalAchievement);
                        break;
                    }
                }
                for (PlayerAchievement playerAchievement : playerAchievements) {
                    if (playerAchievement.name().equals(schemaAchievement.name())) {
                        achievementParams.add(playerAchievement);
                        break;
                    }
                }
                if (achievementParams.size() == 3) {
                    Achievement achievement = new Achievement(
                            (SchemaAchievement) achievementParams.get(0),
                            (GlobalAchievement) achievementParams.get(1),
                            (PlayerAchievement) achievementParams.get(2)
                    );
                    achievements.getChildren().add(
                            achievement.getGUI()
                    );
                } else {
                    achievements.getChildren().add(
                            new Label("Something went wrong")
                    );
                }
            }
        } catch (IOException e) {
            achievements.getChildren().add(
                    new Label("Connection Error or the profile isn't public")
            );
        }

    }
}