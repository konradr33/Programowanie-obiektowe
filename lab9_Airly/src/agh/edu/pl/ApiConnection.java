package agh.edu.pl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ApiConnection {

    public void makeConnection(URL url, CommandArguments arguments) throws IOException {
        //creating a connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //making headers
        connection.setRequestProperty("apikey", arguments.getApiKey());
        connection.setRequestProperty("Accept", "application/json");

        // handling error response code
        int responseCode = connection.getResponseCode();
        InputStream inputStream;
        if (200 <= responseCode && responseCode <= 299) {
            inputStream = connection.getInputStream();
        } else {
            inputStream = connection.getErrorStream();
        }

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

        //response error
        if (responseCode != 200) throw new IOException(responseCode + "\n" + response);

        String[] splitted = response.get(0).split(",");//------------------------------<<<<<<
        for (String line : splitted) {
            System.out.println(line);
        }
    }
}
