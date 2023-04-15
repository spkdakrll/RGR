package com.rgr.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import static com.rgr.demo.MainController.stage;

public class InfoController {

    @FXML
    private Button btnClose;

    @FXML
    void actionClose(MouseEvent event) {
        stage.close();
    }

}
