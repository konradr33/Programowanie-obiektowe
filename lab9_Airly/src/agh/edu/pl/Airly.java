package agh.edu.pl;

import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;

public class Airly {
    public static void main(String[] args) {
        try {
            CommandLineParser parser = new CommandLineParser();
            CommandArguments arguments = parser.parse(args);

            ApiConnection connection = new ApiConnection();
            connection.makeConnection(new URL("https://airapi.airly.eu/v1/mapPoint/measurements?latitude=50.06&longitude=19.93"), arguments);
            //connection.makeConnection(new URL("https://airapi.airly.eu/v1/sensor/measurements"), arguments);


        } catch (UnknownHostException ex) {
            System.out.print(ex + ". Could not connect to host. ");
        } catch (IOException | IllegalArgumentException ex) {
            System.out.print(ex);
        }
    }
}
