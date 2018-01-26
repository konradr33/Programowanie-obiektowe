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

    public void setOperatingMode() {
        OperatingModeSingleton mode = OperatingModeSingleton.getInstance();

        //checking which operatingModeEnum type entered arguments is
        if (!applied[0] && !applied[1] && applied[2]) {
            //data from sensor
            if (applied[4]) {
                mode.setMode(OperatingModeEnum.sensorWithHistory);
            } else {
                mode.setMode(OperatingModeEnum.sensor);
            }
        } else if (applied[0] && applied[1] && !applied[2]) {
            //data from entered coordinates
            if (applied[4]) {
                mode.setMode(OperatingModeEnum.coordinatesWithHistory);
            } else {
                mode.setMode(OperatingModeEnum.coordinates);
            }
        } else throw new IllegalArgumentException("Invalid arguments, --help for more information about app syntax");
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

    public void setSensorId(int sensorId) {
        if (sensorId < 1)
            throw new IllegalArgumentException("Invalid sensorID, --help for more information about app syntax");
        this.sensorId = sensorId;
        this.applied[2] = true;
    }

    public void setHistory(int history) {
        if (history < 1 || history>24)
            throw new IllegalArgumentException("Invalid history, value must be between 1 and 24,  --help for more information about app syntax");
        this.history = history;
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

    public double getLatitude() {
        if (!this.applied[0])
            throw new IllegalArgumentException("No Latitude found, --help for more information about app syntax");
        return this.latitude;
    }

    public double getLongitude() {
        if (!this.applied[1])
            throw new IllegalArgumentException("No Longitude found,, --help for more information about app syntax");
        return this.longitude;
    }
    public int getSensorID() {
        if (!this.applied[2])
            throw new IllegalArgumentException("No SensorID found, --help for more information about app syntax");
        return this.sensorId;
    }
    public int getHistory() {
        if (!this.applied[4])
            throw new IllegalArgumentException("No History value found, --help for more information about app syntax");
        return this.history;
    }


}
