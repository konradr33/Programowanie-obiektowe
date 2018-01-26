package agh.edu.pl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Airly {
    public static void main(String[] args) {
        try {
            //parsing command line and getting arguments
            CommandLineParser parser = new CommandLineParser();
            CommandArguments arguments = parser.parse(args);
            arguments.setOperatingMode();

            //creating url request
            URLCreator creator = new URLCreator();
            URL url = creator.createURl(arguments);

            //making connection and getting data
            ApiConnection connection = new ApiConnection();
            WeatherData data = connection.getWeatherData(url, arguments.getApiKey());
            data.display(arguments);

        } catch (MalformedURLException ex) {
            System.out.print(ex + ". Invalid URL request.\n");
        } catch (UnknownHostException ex) {
            System.out.print(ex + ". Could not connect to host.\n");
        } catch (IOException | IllegalArgumentException ex) {
            System.out.print(ex);
        }
    }
}
