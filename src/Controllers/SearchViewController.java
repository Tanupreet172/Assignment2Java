package Controllers;

import Models.APIResponse;
import Utilities.APIUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private TextField cityTextField;

    @FXML
    private Button searchButton;

    public APIResponse response;
    @FXML
    private void getWeatherInfo(ActionEvent event) throws IOException {
        String searchTest = cityTextField.getText();
        try {
            response = APIUtility.callAPI(searchTest);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }




        FXMLLoader loader = new FXMLLoader();




        loader.setLocation(getClass().getResource("../Views/WeatherView.fxml"));

        Parent root = loader.load();
        WeatherViewController wv=loader.getController();
        wv.settingValue(response,searchTest);
        root.setId("pane");
        Scene weatherScene = new Scene(root);
        //weatherScene.getStylesheets().add("Views/stylesheet.css");
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(weatherScene);
        window.show();


    }

    public APIResponse getRes(){
        return this.response;
}




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

