import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/SearchView.fxml"));
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image("/Views/weather.png"));
        stage.setTitle("Weather Info");
        scene.getStylesheets().add("Views/stylesheet.css");
        stage.setScene(scene);
        stage.show();
    }
}
