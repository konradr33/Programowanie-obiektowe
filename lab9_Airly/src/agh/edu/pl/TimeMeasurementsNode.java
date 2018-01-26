package agh.edu.pl;

public class TimeMeasurementsNode {
    private String fromDateTime;
    private String tillDateTime;
    private Measurements measurements;

    //proper displaying content
    public String toString() {
        return "\nfromDateTime: " + fromDateTime + "\ntillDateTime: " + tillDateTime + measurements.toString() + "\n";
    }
}
