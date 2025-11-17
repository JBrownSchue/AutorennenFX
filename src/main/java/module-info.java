module com.example.autorennenfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.autorennenfx to javafx.fxml;
    exports com.example.autorennenfx;
}