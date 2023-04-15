module com.rgr.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.rgr.demo to javafx.fxml;
    exports com.rgr.demo;
}