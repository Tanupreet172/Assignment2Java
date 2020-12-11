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

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;


import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class WeatherViewController implements Initializable {
    @FXML
    private ImageView imageView;

    @FXML
    private GridPane gridPanes;

    @FXML
    private GridPane gridPane;
    @FXML
    private HBox hBox;
    @FXML
    private VBox vBoxes;

    @FXML
    private VBox vBox;

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
    private Label dateTimeLabel;

    @FXML
    private Label dayLabel;


    @FXML
    void backSearch(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../Views/SearchView.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        Scene searchScene = new Scene(root);
        searchScene.getStylesheets().add("Views/stylesheet.css");
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(searchScene);
        window.show();
    }
    public void settingValue(APIResponse api,String searchTest) throws IOException {
        try {

            humidityLabel.setText(String.valueOf(api.getMain().getHumidity())+" %");
            float cel = (float) (api.getMain().getTemp() - 273.15);
            temperatureLabel.setText(cel + " °C");
            descriptionLabel.setText(api.getWeather()[0].getDescription());
            mainLabel.setText(api.getWeather()[0].getMain());
            windSpeedLabel.setText(String.valueOf(api.getWind().getSpeed())+" m/s");
            feelsLikeLabel.setText(api.getMain().getFeelsLike() + "°");
            pressureLabel.setText(String.valueOf(api.getMain().getPressure())+" hPa");
            float maxCel = (float) (api.getMain().getTempMax() - 273.15);
            maxTempLabel.setText("H: " + maxCel + "°");
            float minCel = (float) (api.getMain().getTempMin() - 273.15);
            minTempLabel.setText("L: " + minCel + "°");
            latitudeLabel.setText(String.valueOf(api.getCoord().getLatitude()));
            longitudeLabel.setText(String.valueOf(api.getCoord().getLongitude()));
            cityLabel.setText(searchTest);
            //BufferedImage image = null;

            //URL url = new URL("http://openweathermap.org/img/wn/" + api.getWeather()[0].getIcon() + "@2x.png");
            //image = ImageIO.read(url);
            Image image = new Image("http://openweathermap.org/img/wn/" + api.getWeather()[0].getIcon() + "@2x.png");

            ImageView img = new ImageView(image);

            imageView.setImage(img.getImage());
        }
        catch(NullPointerException e){
            System.out.print(e);
        }



      /*  if(mainLabel.getText().equalsIgnoreCase("clouds")) {
            FileInputStream inputstream = new FileInputStream("src/Views/img/cloud.png");
            Image image = new Image(inputstream);
            ImageView img = new ImageView(image);
            imageView.setImage(img.getImage());
        }
        if(mainLabel.getText().equalsIgnoreCase("snow")) {
            FileInputStream inputstream = new FileInputStream("src/Views/img/snow.png");
            Image image = new Image(inputstream);
            ImageView img = new ImageView(image);
            imageView.setImage(img.getImage());
        }
        if(mainLabel.getText().equalsIgnoreCase("clear")) {
            FileInputStream inputstream = new FileInputStream("src/Views/img/clear.png");
            Image image = new Image(inputstream);
            ImageView img = new ImageView(image);
            imageView.setImage(img.getImage());
        }*/
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String todayDate = String.valueOf(formatter.format(date));
        dateTimeLabel.setText(todayDate);
        Calendar calendar = Calendar.getInstance();
        Date dates = calendar.getTime();
        String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(dates.getTime());
        dayLabel.setText(String.valueOf(day));



    }
}
