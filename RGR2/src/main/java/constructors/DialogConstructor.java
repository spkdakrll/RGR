package constructors;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.StageStyle;

import java.util.NoSuchElementException;
import java.util.Optional;

public final class DialogConstructor extends Alert {
    public DialogConstructor(AlertType alert_type, String dialog_title, String header_text, String content_text) {
        super(alert_type);
        setTitle(dialog_title);
        setHeaderText(header_text);
        setContentText(content_text);
        initStyle(StageStyle.UTILITY);
        try {
            Optional<ButtonType> option = showAndWait();
            if (option.get() == ButtonType.OK && alert_type == AlertType.CONFIRMATION) {
                System.exit(0);
            }
        } catch(NoSuchElementException e) {
        }
    }
}
