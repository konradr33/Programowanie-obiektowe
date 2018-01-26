package agh.edu.pl;

public class OperatingModeSingleton {
    private OperatingModeEnum mode = null;
    private static OperatingModeSingleton instance = null;

    protected OperatingModeSingleton() {
        // Exists only to defeat instantiation.
    }

    //creating or getting only instance of this Singleton
    public static OperatingModeSingleton getInstance() {
        if (instance == null) {
            instance = new OperatingModeSingleton();
        }
        return instance;
    }

    //setting mode
    public void setMode(OperatingModeEnum argMode) {
        this.mode = argMode;
    }

    //getting mode
    public OperatingModeEnum getMode() {
        return this.mode;
    }
}
