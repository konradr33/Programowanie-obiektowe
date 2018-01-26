package agh.edu.pl;

public class Measurements {
    private double airQualityIndex;
    private double pm1;
    private double pm25;
    private double pm10;
    private double pressure;
    private double humidity;
    private double temperature;
    private int pollutionLevel;

    public String toString() {
        return "\nairQualityIndex: " + airQualityIndex + "\npm1: " + pm1 + "\npm25: " + pm25 + "\npm10: " + pm10 + "\npressure: " + pressure + "\nhumidity: " + humidity + "\ntemperature: " + temperature + "\npollutionLevel: " + pollutionLevel;
    }
}