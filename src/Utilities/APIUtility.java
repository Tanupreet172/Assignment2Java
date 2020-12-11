package Utilities;


import Models.APIResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class calls the weather API and return
 * various types of content
 */

public class APIUtility {

    public static APIResponse callAPI(String searchText) throws IOException, InterruptedException {
        String jsonLocation=null;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://community-open-weather-map.p.rapidapi.com/weather?q=" + searchText))
                    .header("x-rapidapi-key", "ca0190f0d8msh08c1134e34f98c5p1abc2cjsnf8479722e1ca")
                    .header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            jsonLocation = "src/Utilities/weather.json";
            HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers
                    .ofFile(Paths.get(jsonLocation)));

        }
        catch(NullPointerException e){
            System.out.print(e);
        }
        return getWeatherFromJSON(new File(jsonLocation));
    }



    public static APIResponse getWeatherFromJSON(File jsonFile)
    {
        Gson gson = new Gson();
        APIResponse searchResult = null;

        //using try "with resources"
        try(
                FileReader fileReader = new FileReader(jsonFile);
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            searchResult = gson.fromJson(jsonReader, APIResponse.class);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return searchResult;
    }
}