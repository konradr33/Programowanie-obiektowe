package agh.edu.pl;

import java.net.MalformedURLException;
import java.net.URL;

public class URLCreator {

    //creating URL from applied command arguments
    public URL createURl(CommandArguments arguments) throws MalformedURLException {
        OperatingModeSingleton mode = OperatingModeSingleton.getInstance();
        StringBuilder url = new StringBuilder();

        switch (mode.getMode()) {
            case coordinates:
            case coordinatesWithHistory:
                url.append("https://airapi.airly.eu/v1/mapPoint/measurements?latitude=");
                url.append(arguments.getLatitude());
                url.append("&longitude=");
                url.append(arguments.getLongitude());
                System.out.println();
                break;
            case sensor:
            case sensorWithHistory:
                url.append("https://airapi.airly.eu/v1/sensor/measurements?sensorId=");
                url.append(arguments.getSensorID());
                break;
        }

        return new URL(url.toString());
    }
}
