module org.example.steamapiproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.steamapiproject to javafx.fxml;
    exports org.example.steamapiproject;
}