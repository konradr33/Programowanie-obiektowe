package agh.edu.pl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ApiConnection {

    public void makeConnection(String URL,String ApiKey) throws IOException {
        //creating a connection
        HttpURLConnection connection = (HttpURLConnection) new URL("https://airapi.airly.eu/v1/sensors/1").openConnection();

        //declaring apiKey
        String apiKey;
        if (System.getenv("API_KEY") == null) {
            apiKey = "b0f33c69d7a941d3ae48689a48f3d204";
        } else {
            apiKey = System.getenv("API_KEY");
        }

        //making headers
        connection.setRequestProperty("apikey", apiKey);
        connection.setRequestProperty("Accept", "application/json");

        // handling error response code
        int responseCode = connection.getResponseCode();
        InputStream inputStream;
        if (200 <= responseCode && responseCode <= 299) {
            inputStream = connection.getInputStream();
        } else {
            inputStream = connection.getErrorStream();

        }

        System.out.println(responseCode);//------------------------------<<<<<<

        //Reading response
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        inputStream));

        ArrayList<String> response = new ArrayList();
        String currentLine;
        while ((currentLine = in.readLine()) != null)
            response.add(currentLine);
        in.close();
        connection.disconnect();

        for (String line : response) {
            System.out.println(line);//------------------------------<<<<<<
        }
    }
}
