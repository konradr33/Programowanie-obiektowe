package agh.edu.pl;

public class Error {
    private String code;
    private String message;

    //handle errors
    public void display(){
        System.out.println("code: "+code+", message: "+message);
    }
}
