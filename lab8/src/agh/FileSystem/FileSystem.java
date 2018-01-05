package agh.FileSystem;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSystem {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Wprowadź prawidłowe dane, jeżeli chcesz wiedzieć więcej wpisz -h");
            String line = keyboard.nextLine();

            Parser parser = new Parser();
            //while(parser.parse(line.split(" "))){
            while(parser.parse(args)){
                System.out.println("Wprowadź dane");
                line = keyboard.nextLine();
            }
            parser.loadFile();
            parser.view();



        } catch (IllegalArgumentException ex) {
            System.out.print(ex);
        } catch (FileNotFoundException ex){
            System.out.print(ex);
        }
    }
}

