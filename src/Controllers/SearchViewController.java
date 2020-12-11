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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
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

    @FXML
    private VBox vBoxess;

    @FXML
    private Label nameLabel;

    @FXML
    private Label mainsLabel;

    @FXML
    private ImageView imagesView;

    @FXML
    private Label tempLabel;

    public APIResponse response;


    @FXML
    private void getWeatherInfo(ActionEvent event) throws IOException,NullPointerException {
        String searchTest = cityTextField.getText();
        String e="error";
        try {

            String filtered=searchTest.replaceAll(" ","%20");

            response = APIUtility.callAPI(filtered);

            response.getMain().getTemp();

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
        APIResponse res=null;
        try {
             res = APIUtility.callAPI("Barrie");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nameLabel.setText("Georgian College");
        mainsLabel.setText(res.getWeather()[0].getMain());
        Image image = new Image("http://openweathermap.org/img/wn/" + res.getWeather()[0].getIcon() + "@2x.png");

        ImageView img = new ImageView(image);

        imagesView.setImage(img.getImage());
        float cel = (float) (res.getMain().getTemp() - 273.15);
        tempLabel.setText(cel+ "°C");
    }
}

