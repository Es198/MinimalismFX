module com.example.minimalismfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.minimalismfx to javafx.fxml;
    exports com.example.minimalismfx;
}