package agh.edu.pl;

import java.util.List;

public class WeatherData {
    private Measurements currentMeasurements;
    private List<TimeMeasurementsNode> history;
    private List<TimeMeasurementsNode> forecast;

    //convert content to String
    public String toString(CommandArguments arg) {
        StringBuilder string = new StringBuilder();
        string.append("Current");
        string.append(currentMeasurements.toString());

        OperatingModeSingleton mode=OperatingModeSingleton.getInstance();
        if(mode.getMode()==OperatingModeEnum.coordinatesWithHistory || mode.getMode()==OperatingModeEnum.sensorWithHistory ){
            this.addHistory(arg.getHistory(),string);
        }

        return string.toString();
    }

    //if history argument is applied, display proper number of history data
    private void addHistory(int history,StringBuilder string){
        string.append("\n\n\nhistory");
        for (int i=this.history.size()-1;i >= this.history.size()-history; i--) {
            string.append(this.history.get(i).toString());
        }
    }
}
