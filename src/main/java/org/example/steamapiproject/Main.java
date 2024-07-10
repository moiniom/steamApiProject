package org.example.steamapiproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    private SteamAPI api = new SteamAPI();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = new AnchorPane();
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu settingsMenu = new Menu("Settings");
        MenuItem exitItem = new MenuItem("Exit");
        MenuItem settingApiKey = new MenuItem("Change API Key");

        root.getChildren().addAll(menuBar);
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