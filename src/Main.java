import Models.APIResponse;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try(
                FileReader fileReader = new FileReader("src/weather.json");
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            Gson gson = new Gson();
            APIResponse apiResponse = gson.fromJson(jsonReader,APIResponse.class);
            System.out.println();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
