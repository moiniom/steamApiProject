module org.example.steamapiproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens org.example.steamapiproject to javafx.fxml;
    exports org.example.steamapiproject;
}