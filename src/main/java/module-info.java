module org.example.steamapiproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens org.example.steamapiproject to javafx.fxml;
    exports org.example.steamapiproject;
    exports org.example.steamapiproject.schemaresponse;
    exports org.example.steamapiproject.playerachivementresponse;
    exports org.example.steamapiproject.ownedresponse;
    exports org.example.steamapiproject.globalachievementresponse;
    opens org.example.steamapiproject.schemaresponse to javafx.fxml;
}