package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmls/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 467, 563);
        stage.setTitle("Налоговый калькулятор. Калькулятор имущества");
        stage.setScene(scene);
        stage.show();
    }

    public final void fxml_launcher(String[] args) {
        launch();

    }
}