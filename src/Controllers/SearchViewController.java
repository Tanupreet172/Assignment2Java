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
import javafx.scene.control.Label;
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

    @FXML
    private Label errMsgLabel;

    public APIResponse response;
    @FXML
    private void getWeatherInfo(ActionEvent event) throws IOException,NullPointerException {
        String searchTest = cityTextField.getText();
        String e="error";
        try {
            response = APIUtility.callAPI(searchTest);

            System.out.print(response.getMain().getTemp());
        }
            catch (IOException | InterruptedException | NullPointerException f) {
                e=f.toString();

            }

            if(!e.equalsIgnoreCase("java.lang.NullPointerException")) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../Views/WeatherView.fxml"));

                Parent root = loader.load();
                WeatherViewController wv = loader.getController();
                wv.settingValue(response, searchTest);


                root.setId("pane");
                Scene weatherScene = new Scene(root);
                weatherScene.getStylesheets().add("Views/stylesheet.css");
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(weatherScene);
                window.show();
            }
            else{
                errMsgLabel.setText("Enter a  valid city!");

            }
        }


    public APIResponse getRes(){
        return this.response;
}




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errMsgLabel.setText("");
    }
}

