package agh.edu.pl;

public class ApiArguments {
    private double latitude;
    private double longitude;
    private int sensorId;
    private String apiKey=null;
    private int history;
    private boolean[] applied=new boolean[5];

    public void ApiArguments(){
        for(int i=0;i<5;i++){
            applied[i]=false;
        }
    }

    public void setLatitude(double latitude){
        this.latitude=latitude;
        this.applied[0]=true;
    }

    public void setLongitude(double longitude){
        this.longitude=longitude;
        this.applied[1]=true;
    }

    public void setSendorId(int sensorId){
        this.sensorId=sensorId;
        this.applied[2]=true;
    }

    public void setHistory(int history){
        this.sensorId=history;
        this.applied[4]=true;
    }

    public void setApiKey(String apiKey){
        this.apiKey=apiKey;
        this.applied[3]=true;
    }
}
