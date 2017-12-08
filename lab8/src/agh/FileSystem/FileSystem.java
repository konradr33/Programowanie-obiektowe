package agh.FileSystem;

public class FileSystem {
    public static void main(String[] args) {
        try {
            Parser parser = new Parser();
            parser.parse(args);

        } catch (IllegalArgumentException ex) {
        System.out.print(ex);
        }
        finally {

        }

    }
}
