package agh.edu.pl;

public class OperatingModeSingleton {
    private OperatingModeEnum mode = null;
    private static OperatingModeSingleton instance = null;

    protected OperatingModeSingleton() {
        // Exists only to defeat instantiation.
    }

    public static OperatingModeSingleton getInstance() {
        if (instance == null) {
            instance = new OperatingModeSingleton();
        }
        return instance;
    }

    public void setMode(OperatingModeEnum argMode) {
        this.mode = argMode;
    }

    public OperatingModeEnum getMode() {
        return this.mode;
    }
}
