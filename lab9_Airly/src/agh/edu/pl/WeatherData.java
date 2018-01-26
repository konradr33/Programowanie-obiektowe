package agh.edu.pl;

import java.io.IOException;
import java.util.List;

public class WeatherData {
    private Measurements currentMeasurements;
    private List<TimeMeasurementsNode> history;
    private List<TimeMeasurementsNode> forecast;
    private List<Error> errors;

    //check if contains any errors
    public void checkErrors() throws IOException{
        if (errors!=null){
            for (Error error:errors) {
                error.display();
            }
            throw new IOException("Errors occured.");
        }
    }
    //convert content to String
    public void display(CommandArguments arg) {
        System.out.println("\nCURRENT");
        currentMeasurements.display();
        OperatingModeSingleton mode=OperatingModeSingleton.getInstance();
        if(mode.getMode()==OperatingModeEnum.coordinatesWithHistory || mode.getMode()==OperatingModeEnum.sensorWithHistory ){
            this.addHistory(arg.getHistory());
        }
    }

    //if history argument is applied, display proper number of history data
    private void addHistory(int history){
        System.out.println(Visualalizer.wall);
        System.out.println("HISTORY\n");
        for (int i=this.history.size()-1;i >= this.history.size()-history; i--) {
            this.history.get(i).display();
        }
    }
}
