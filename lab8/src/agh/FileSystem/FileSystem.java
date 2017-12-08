package agh.FileSystem;

import java.util.Scanner;

public class FileSystem {
    private Scanner reader= new Scanner(System.in);
    public static void main(String[] args) {
        try {
            //Parser parser = new Parser();
            //parser.parse(args);

            System.out.println("Enter a number: ");
            int n = reader.nextInt(); // Scans the next token of the input as an int.
//once finished

            System.out.println("\n"+ n);

        } catch (IllegalArgumentException ex) {
        System.out.print(ex);
        }
        finally {
            reader.close();
        }

    }
}
