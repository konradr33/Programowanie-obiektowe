package agh.edu.pl;

public class TimeMeasurementsNode {
    private String fromDateTime;
    private String tillDateTime;
    private Measurements measurements;

    //proper displaying content
    public void display() {
        String date=fromDateTime.substring(0,10);
        String startHour=fromDateTime.substring(11,16);
        String endHour=tillDateTime.substring(11,16);
        System.out.println( "Day: "+date+"\nHour: "+startHour+"-"+endHour );
        measurements.display();
    }
}
