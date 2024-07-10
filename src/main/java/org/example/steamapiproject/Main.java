package org.example.steamapiproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application{
    private SteamAPI api = new SteamAPI();

    private AnchorPane root = new AnchorPane();
    private MenuBar menuBar = new MenuBar();
    private Menu fileMenu = new Menu("File");
    private Menu settingsMenu = new Menu("Settings");
    private MenuItem exitItem = new MenuItem("Exit");
    private MenuItem settingApiKey = new MenuItem("Change API Key");
    private ScrollPane games = new ScrollPane();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {


        root.getChildren().add(
                new VBox(
                        menuBar,
                        new HBox(
                                games
                        )
                )
        );

        menuBar.getMenus().addAll(
                fileMenu,
                settingsMenu
        );
        fileMenu.getItems().addAll(exitItem);
        settingsMenu.getItems().addAll(settingApiKey);

        exitItem.setOnAction(event -> stage.close());
        settingApiKey.setOnAction(event -> setKeyWin());

        stage.setTitle("Steam API");
        stage.setScene(new Scene(root, 500, 500));
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
}