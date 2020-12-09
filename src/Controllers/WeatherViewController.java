package Controllers;

import Models.APIResponse;
import Models.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WeatherViewController implements Initializable {

    @FXML
    private Label humidityLabel;

    @FXML
    private Button backButton;

    @FXML
    private Label temperatureLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label mainLabel;

    @FXML
    private Label windSpeedLabel;

    @FXML
    private Label feelsLikeLabel;

    @FXML
    private Label pressureLabel;

    @FXML
    private Label maxTempLabel;

    @FXML
    private Label minTempLabel;

    @FXML
    private Label latitudeLabel;

    @FXML
    private Label longitudeLabel;

    @FXML
    private Label cityLabel;


    @FXML
    void backSearch(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Views/SearchView.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        Scene searchScene = new Scene(root);
        //searchScene.getStylesheets().add("Views/stylesheet.css");
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(searchScene);
        window.show();
    }
    public void settingValue(APIResponse api){
        humidityLabel.setText(String.valueOf(api.getMain().getHumidity()));
        float cel= (float) (api.getMain().getTemp()-273.15);
        temperatureLabel.setText(cel+" celsius");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
