package agh.edu.pl;

public class Measurements {
    private double airQualityIndex = -200;
    private double pm1 = -200;
    private double pm25 = -200;
    private double pm10 = -200;
    private double pressure = -200;
    private double humidity = -200;
    private double temperature = -200;
    private int pollutionLevel = -200;

    //proper displaying content
    public void display() {
        StringBuilder string = new StringBuilder();
        String[] sign = Visualalizer.getSign(airQualityIndex);

        for (int i = 0; i < 14; i++) {
            switch (i) {
                case 1:
                    if (airQualityIndex == -200) {
                        string.append("CAQI: -- \n");
                    } else {
                        string.append("CAQI: " + (int) airQualityIndex + "\n");
                    }
                    break;
                case 3:
                    if (pm25 == -200) {
                        string.append("PM2.5: -- μg/m3\n");
                    } else {
                        string.append("PM2.5: " + (int) pm25 + " μg/m3\n");
                    }
                    break;
                case 5:
                    if (pm10 == -200) {
                        string.append("PM10: -- μg/m3\n");
                    } else {
                        string.append("PM10: " + (int) pm10 + " μg/m3\n");
                    }
                    break;
                case 7:
                    if (temperature == -200) {
                        string.append("temperature: -- °C\n");
                    } else {
                        string.append("temperature: " + Math.round(temperature) + "°C\n");
                    }
                    break;
                case 9:
                    if (pressure == -200) {
                        string.append("press: -- hPa\n");
                    } else {
                        string.append("pressure: " + (int) pressure / 100 + " hPa\n");
                    }
                    break;
                case 11:
                    if (humidity == -200) {
                        string.append("humidity: -- %\n");
                    } else {
                        string.append("humidity: " + (int) humidity + "%\n");

                    }
                    break;
                default:
                    if (i == 13) i++;
                    string.append(sign[i / 2]);
                    if (i > 11) string.append("\n");
                    break;
            }
        }
        System.out.println(string);
    }
}