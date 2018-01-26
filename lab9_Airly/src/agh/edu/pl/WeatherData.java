package agh.edu.pl;

import java.util.List;

public class WeatherData {
    private Measurements currentMeasurements;
    private List<TimeMeasurementsNode> history;
    private List<TimeMeasurementsNode> forecast;

    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("\n\n\nCurrent");
        string.append(currentMeasurements.toString());
        string.append("\n\n\nhistory");
        for (TimeMeasurementsNode node : history) {
            string.append(node.toString());
        }
        string.append("\n\n\nforecast");
        for (TimeMeasurementsNode node : forecast) {
            string.append(node.toString());
        }
        return string.toString();
    }
}
