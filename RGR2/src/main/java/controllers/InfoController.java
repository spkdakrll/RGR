package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import static controllers.MainController.stage;

public class InfoController {

    @FXML
    private Button btnClose;

    @FXML
    void actionClose(MouseEvent event) {
        stage.close();
    }

}
