package agh.edu.pl;

public class CommandArguments {
    private double latitude;
    private double longitude;
    private int sensorId;
    private String apiKey = null;
    private int history;
    private boolean[] applied = new boolean[5];

    public CommandArguments() {
        for (int i = 0; i < 5; i++) {
            this.applied[i] = false;
        }
    }

    public void setLatitude(double latitude) {
        if (latitude > 55 || latitude < 48)
            throw new IllegalArgumentException("Invalid latitude, --help for more information about app syntax");
        this.latitude = latitude;
        this.applied[0] = true;
    }

    public void setLongitude(double longitude) {
        if (longitude > 24 || longitude < 13)
            throw new IllegalArgumentException("Invalid longitude, --help for more information about app syntax");
        this.longitude = longitude;
        this.applied[1] = true;
    }

    public void setSendorId(int sensorId) {
        this.sensorId = sensorId;
        this.applied[2] = true;
    }

    public void setHistory(int history) {
        this.sensorId = history;
        this.applied[4] = true;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
        this.applied[3] = true;
    }

    public boolean hasApiKey() {
        return this.applied[3];
    }

    public String getApiKey() {
        if (!this.applied[3])
            throw new IllegalArgumentException("No API Key found, check if you have entered the correct key or if there is a suitable environment variable ( API_KEY ), --help for more information about app syntax");
        return this.apiKey;
    }
}
