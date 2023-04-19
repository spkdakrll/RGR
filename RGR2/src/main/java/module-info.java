module com.rgr.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires itextpdf;

    exports calc;
    exports launcher;
    opens launcher to javafx.fxml;
    exports constructors;
    opens constructors to javafx.fxml;
    exports controllers;
    opens controllers to javafx.fxml;
    exports handler;
    opens handler to javafx.fxml;
}