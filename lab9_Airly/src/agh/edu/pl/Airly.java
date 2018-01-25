package agh.edu.pl;

import java.io.IOException;

public class Airly {
    public static void main(String[] args) {
        try {
            CommandLineParser parser = new CommandLineParser();
            parser.parse(args);

            ApiConnection connection = new ApiConnection();
            connection.makeConnection("","");

            ErrorSupport error = new ErrorSupport();
            //error.checkIsInt("13");

        } catch (IOException ex) {
            System.out.print(ex);
        } catch (IllegalArgumentException ex) {
            System.out.print(ex);
        }
    }
}
