package agh.FileSystem;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Konstytucja implements FileToRead  {
    private ArrayList<String[]> content = new ArrayList<String[]>();
    private List<Node> rozdzialy = new ArrayList<Node>();
    private List<Node> artykuly = new ArrayList<Node>();
    private List<Node> ustepy = new ArrayList<Node>();
    private List<Node> punkty = new ArrayList<Node>();

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
    }


    public void loadFile(String fileName) throws FileNotFoundException{


        Scanner in = new Scanner(new FileInputStream(fileName), "UTF-8");
        String[] temp;
        while(in.hasNextLine()){
            temp=in.nextLine().split(" ");
            if(temp[0].startsWith("©")) {
                temp=in.nextLine().split(" ");
                temp=in.nextLine().split(" ");
                content.add(temp);
            }else if(temp.length>1 || temp[0].length()>=2){
                content.add(temp);
            }

        }

        if(content.get(1)[0].equals("2009-11-16")) {
            content.remove(0);
            content.remove(0);
        }

        for(int i=0;i<content.size();i++){
            if(content.get(i)[content.get(i).length-1].endsWith("-")){
                content.get(i)[content.get(i).length-1]= content.get(i)[content.get(i).length-1].substring(0,content.get(i)[content.get(i).length-1].length()-1)+content.get(i+1)[0];
                if(content.get(i+1).length==1) content.remove(i+1);
                else content.get(i+1)[0]="";
            }
        }
    }




    public void loadIntoObjects() {
            Node temp=new Node();
            Node temp_roz=temp;
            Node temp_art=new Node();temp_art.setID(0);
            Node temp_ust=new Node();temp_ust.setID(0);
            Node temp_pod=new Node();temp_pod.setID(0);

        rozdzialy.add(temp);
        temp.setID(0);
        for(int i=0;i<content.size();i++){
            if(content.get(i)[0].equals("Rozdział")){
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
                //if(! content.get(i)[0].substring(0,content.get(i)[0].length()-2).equals("")) {
                //    temp.setID(Integer.parseInt(content.get(i)[0].substring(0, content.get(i)[0].length() - 2)));
                //}
                //temp.setID(temp_ust.getID()+1);
                temp_ust=temp;
                ustepy.add(temp_ust);
            }
            else if(content.get(i)[0].endsWith(")") && content.get(i).length>1 && content.get(i)[0].substring(0,content.get(i)[0].length()-2).length()>0 && isDigit(content.get(i)[0].substring(0, content.get(i)[0].length() - 2))){
                temp=new Node();
                temp.addLine(content.get(i));
                temp_ust.addChild(temp);
                //if(! content.get(i)[0].substring(0,content.get(i)[0].length()-2).equals("")) {
                //   temp.setID(Integer.parseInt(content.get(i)[0].substring(0, content.get(i)[0].length() - 2)));
                //}
                //temp.setID(temp_pod.getID()+1);
                temp_pod=temp;
            }
            else {temp.addLine(content.get(i));}

        }

    }
    public void view_spis(){
        if(rozdzialy.isEmpty()) return;
        for(int i=0;i<rozdzialy.size();i++){
            rozdzialy.get(i).single_view();
        }
    }

    public void view_a(){
        if(rozdzialy.isEmpty()) return;
        for(int i=0;i<rozdzialy.size();i++){
            rozdzialy.get(i).view_a();
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

    public void view_a(String x,String y) {
        Node start=null;
        Node stop=null;
        boolean temp=false;
        for (int i = 0; i < artykuly.size(); i++) {
            if (artykuly.get(i).getID().equals(x)) {
                start = artykuly.get(i);
                break;
            }
        }
        for (int i = 0; i < artykuly.size(); i++) {
            if (artykuly.get(i).getID().equals(y)) {
                stop = artykuly.get(i);
                break;
            }
        }
        if(stop==null){
            throw  new IllegalArgumentException( y + "Nie istnieje");
        }
        for (int i = 0; i < artykuly.size(); i++) {
            if(artykuly.get(i)==start) temp=true;
            if (temp) {
                artykuly.get(i).view_a();
            }
            if(artykuly.get(i)==stop)return;
        }
    }

    public void view_b(){

    }

    public void view_c(String x){
        int temp=-1;
        if(rozdzialy.isEmpty()) return;
        for(int i=0;i<rozdzialy.size();i++){
            if(rozdzialy.get(i).getTitle().equals(x)){temp=rozdzialy.get(i).getIDInt();}
            if(rozdzialy.get(i).getIDInt()==temp){ rozdzialy.get(i).view_a();}
        }
    }



    public void view_d(){
        return;
    }

}
