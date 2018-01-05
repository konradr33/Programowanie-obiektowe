package agh.FileSystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uokik implements FileToRead {
    private ArrayList<String[]> content = new ArrayList<String[]>();
    private List<Node> dzialy = new ArrayList<Node>();
    private List<Node> rozdzialy = new ArrayList<Node>();
    private List<Node> artykuly = new ArrayList<Node>();
    private List<Node> ustepy = new ArrayList<Node>();
    private List<Node> punkty = new ArrayList<Node>();


    public void loadFile(String fileName)  throws FileNotFoundException{

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
            Node temp=new Node();
            Node temp_dzial=temp;
            Node temp_roz=new Node();temp_roz.setID(0);
            Node temp_art=new Node();temp_art.setID(0);
            Node temp_ust=new Node();temp_ust.setID(0);
            Node temp_pod=new Node();temp_pod.setID(0);

            rozdzialy.add(temp);
            temp.setID(0);
            for(int i=0;i<content.size();i++){
                if(content.get(i)[0].equals("Dział")){
                    temp=new Node();
                    temp.setTitle(content.get(i)[0]+" "+content.get(i)[1]);
                    temp.setID(temp_dzial.getIDInt()+1);
                    temp_dzial=temp;
                    i++;
                    temp.addDescribtion(content.get(i));
                    rozdzialy.add(temp_roz);
                }
                else if(content.get(i)[0].equals("Rozdział")){
                    temp=new Node();
                    temp.setTitle(content.get(i)[0]+" "+content.get(i)[1]);
                    temp.setID(temp_roz.getIDInt()+1);
                    temp_roz=temp;
                    rozdzialy.add(temp_roz);
                }
                else if(isUpper(content.get(i)[0]) && isLetters(content.get(i)[0]) && content.get(i)[0].length()>1){
                    temp=new Node();
                    temp.addDescribtion(content.get(i));
                    temp.setID(temp_roz.getIDInt());
                    temp_roz=temp;
                    rozdzialy.add(temp_roz);
                }
                else if(content.get(i)[0].equals("Art.")){
                    temp=new Node();
                    temp_roz.addChild(temp);
                    //if(! (content.get(i)[0].length()>2)) {
                    //   temp.setID(Integer.parseInt(content.get(i)[1].substring(0, content.get(i)[1].length() - 2)));
                    //}
                    //temp.setID(temp_art.getID()+1);
                    temp.addLine(content.get(i));

                    temp_art=temp;
                    temp=new Node();
                    temp_ust=temp;
                    temp_art.addChild(temp);

                    artykuly.add(temp_art);
                }
                else if(content.get(i)[0].endsWith(".") && content.get(i).length>1 && content.get(i)[0].substring(0,content.get(i)[0].length()-2).length()>0 && isDigit(content.get(i)[0].substring(0, content.get(i)[0].length() - 2))){
                    temp=new Node();
                    temp.addLine(content.get(i));
                    temp_art.addChild(temp);
                    temp_ust=temp;
                    ustepy.add(temp_ust);
                }
                else if(content.get(i)[0].endsWith(")") && content.get(i).length>1 && content.get(i)[0].substring(0,content.get(i)[0].length()-2).length()>0 && isDigit(content.get(i)[0].substring(0, content.get(i)[0].length() - 2))){
                    temp=new Node();
                    temp.addLine(content.get(i));
                    temp_ust.addChild(temp);
                    temp_pod=temp;
                }
                else if(content.get(i)[0].endsWith(")") && content.get(i).length>1 && content.get(i)[0].substring(0,content.get(i)[0].length()-2).length()>0 && isLetters(content.get(i)[0].substring(0, content.get(i)[0].length() - 2))){
                    temp=new Node();
                    temp.addLine(content.get(i));
                    temp_pod.addChild(temp);
                }
                else {temp.addLine(content.get(i));}

            }

        }


    public void view_spis(){
        for(int i=0;i<dzialy.size();i++){
            for(int j=0;j<dzialy.get(i).getChildren().size();j++){
                dzialy.get(i).getChildren().get(j).single_view();
            }

        }
    }

    public void view_a(){
        if(dzialy.isEmpty()) return;
        for(int i=0;i<dzialy.size();i++){
            dzialy.get(i).view_a();
        }
    }

    public void view_a(String x){
        for(int i=0;i<artykuly.size();i++){
            if(artykuly.get(i).getID().equals(x)) {
                artykuly.get(i).view_a();
                return;
            }
        }
        throw  new IllegalArgumentException(x + " taki artykuł nie istnieje");
    }

    public void view_a(String x,String y){
    }

    public void view_b(String x){

    }

    public void view_c(String x){
        int temp=-1;
        if(rozdzialy.isEmpty()) return;
        for(int i=0;i<rozdzialy.size();i++){
            if(rozdzialy.get(i).getTitle().equals(x)){temp=rozdzialy.get(i).getIDInt();}
            if(rozdzialy.get(i).getIDInt()==temp){ rozdzialy.get(i).view_a();}
        }
    }


    public void view_d(String x){
        int temp=-1;
        if(rozdzialy.isEmpty()) return;
        for(int i=0;i<rozdzialy.size();i++){
            if(rozdzialy.get(i).getTitle().equals(x)){temp=rozdzialy.get(i).getIDInt();}
            if(rozdzialy.get(i).getIDInt()==temp){ rozdzialy.get(i).view_a();}
        }
    }


    public boolean isUpper(String s) {
        for(char c : s.toCharArray()) {
            if(! Character.isUpperCase(c))
                return false;
        }
        return true;
    }

    public boolean isLetters(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isDigit(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }}
