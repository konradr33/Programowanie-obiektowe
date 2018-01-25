package agh.edu.pl;
import java.io.IOException;
import java.net.URL;

public class Airly {
    public static void main(String[] args) {
        try {
            CommandLineParser parser = new CommandLineParser();
            CommandArguments arguments=parser.parse(args);

            ApiConnection connection = new ApiConnection();
            connection.makeConnection(new URL("https://airapi.airly.eu/v1/nearestSensor/measurements?latitude=50.06&longitude=20&maxDistance=1000"),arguments);

        } catch (IOException ex) {
            System.out.print(ex);
        } catch (IllegalArgumentException ex) {
            System.out.print(ex);
        }
    }
}
