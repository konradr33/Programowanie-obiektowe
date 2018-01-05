package agh.FileSystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uokik implements FileToRead {
    private File file;
    private List<String[]> content = new ArrayList<String[]>();


    public void loadFile(String fileName) throws FileNotFoundException {
        file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(fileName + " nie istnieje");
        }

        Scanner in = new Scanner(new FileInputStream(fileName), "UTF-8");
        while (in.hasNextLine()) {
            String[] temp = in.nextLine().split(" ");
            if (temp[0].startsWith("©Kancelaria")) {
                temp = in.nextLine().split(" ");
                temp = in.nextLine().split(" ");
                content.add(temp);
            } else content.add(temp);
        }


        for (int i = 0; i < content.size(); i++) {
            for (int j = 0; j < content.get(i).length; j++) {
                System.out.print(content.get(i)[j] + " ");
            }
            System.out.print("\n");
        }


        for (int i = 0; i < content.size(); i++) {
            if (content.get(i)[content.get(i).length - 1].endsWith("-")) {
                content.get(i)[content.get(i).length - 1] = content.get(i)[content.get(i).length - 1].substring(0, content.get(i)[content.get(i).length - 1].length() - 1) + content.get(i + 1)[0];
                if (content.get(i + 1).length == 1) content.remove(i + 1);
                else content.get(i + 1)[0] = "";
            }
        }
    }


    public void loadIntoObjects() {

    }
}
