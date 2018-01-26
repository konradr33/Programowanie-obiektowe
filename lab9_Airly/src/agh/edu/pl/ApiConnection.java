package agh.edu.pl;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnection {

    public WeatherData getWeatherData(URL url, String apiKey) throws IOException {
        //creating a connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //making headers
        connection.setRequestProperty("apikey", apiKey);
        connection.setRequestProperty("Accept", "application/json");

        // handling error response code
        int responseCode = connection.getResponseCode();
        InputStream inputStream;
        if (responseCode==200) {
            inputStream = connection.getInputStream();
        } else {
            inputStream = connection.getErrorStream();
        }

        if (inputStream == null) throw new IOException("Error code: " + responseCode + ", null response");

        //Reading response
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        inputStream));

        StringBuilder response = new StringBuilder();
        String currentLine;
        while ((currentLine = in.readLine()) != null)
            response.append(currentLine);
        in.close();
        connection.disconnect();


        //response error
        if (responseCode != 200) throw new IOException("Error code: "+responseCode + ", " + response);

        //converting JSON to WeatherData
        Gson gson = new Gson();
        WeatherData data = gson.fromJson(response.toString(), WeatherData.class);
        data.checkErrors();

        return data;
    }
}
