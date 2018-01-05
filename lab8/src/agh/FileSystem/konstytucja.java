package agh.FileSystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Konstytucja implements FileToRead  {
    private File file;
    private List<String[]> content = new ArrayList<String[]>();
    private List<Node> rozdzialy = new ArrayList<Node>();
    private List<Node> artykuly = new ArrayList<Node>();
    private List<Node> ustepy = new ArrayList<Node>();
    private List<Node> punkty = new ArrayList<Node>();


    public void loadFile(String fileName) throws FileNotFoundException{
        file=new File (fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(fileName + " nie istnieje");
        }

        Scanner in = new Scanner(new FileInputStream(fileName), "UTF-8");
        while(in.hasNextLine()){
            String[] temp=in.nextLine().split(" ");
            if(temp[0].startsWith("©Kancelaria")) {
                temp=in.nextLine().split(" ");
                temp=in.nextLine().split(" ");
                content.add(temp);
            }else if(temp.length>1 || temp[0].length()>=2){
                content.add(temp);
            }

        }

        for(int i=0;i<content.size();i++){
            if(content.get(i)[content.get(i).length-1].endsWith("-")){
                content.get(i)[content.get(i).length-1]= content.get(i)[content.get(i).length-1].substring(0,content.get(i)[content.get(i).length-1].length()-1)+content.get(i+1)[0];
                if(content.get(i+1).length==1) content.remove(i+1);
                else content.get(i+1)[0]="";
            }
        }


        /*for(int i=0;i<content.size();i++){
            for(int j=0;j<content.get(i).length;j++){
                System.out.print(content.get(i)[j]+" ");
            }
            System.out.print("\n");
        }*/
    }

    public static boolean isUpper(String s) {
        for(char c : s.toCharArray()) {
            if(! Character.isUpperCase(c))
                return false;
        }
        return true;
    }


    public void loadIntoObjects() throws NumberFormatException {
        Node temp=new Node();
        Node temp_roz=temp;
        Node temp_art=temp;
        Node temp_ust=temp;
        Node temp_pkt=temp;

        rozdzialy.add(temp_roz);
        temp_roz.setID(1);
        for(int i=0;i<content.size();i++){
            if(content.get(i)[0].equals("Rozdział")){
                temp=new Node();
                temp.addLine(content.get(i));
                temp_roz=temp;
                temp_roz.setID(temp.getID()+1);
                rozdzialy.add(temp_roz);
                while(isUpper(content.get(i+1)[0])){
                    i++;
                    temp_roz.addLine(content.get(i));
                }
            }
            else if(isUpper(content.get(i)[0])){
                temp=new Node();
                temp.addLine(content.get(i));
                temp.setID(temp_roz.getID());
                temp_roz=temp;
                rozdzialy.add(temp_roz);
                while(isUpper(content.get(i+1)[0])){
                    i++;
                    temp_roz.addLine(content.get(i));
                }
            }
            else if(content.get(i)[0].equals("Art.")){
                temp=new Node();
                temp_roz.addChild(temp);
                temp.setID(Integer.parseInt(content.get(i)[1].substring(0,content.get(i)[1].length()-2)));
                temp.addLine(content.get(i));
                temp_art=temp;
                artykuly.add(temp_art);
                int x=content.get(i+1)[0].length()-1;
                while( !(content.get(i+1)[0].equals("Rozdział") || content.get(i+1)[0].equals("Art.") || content.get(i+1)[0].substring(x,x).equals(".") || content.get(i+1)[0].substring(x,x).equals(")") )){
                    i++;
                    temp_art.addLine(content.get(i));
                }
            }
            else if(content.get(i)[0].substring (content.get(i)[0].length()-1,content.get(i)[0].length()-1).equals(".") && content.get(i).length>1 && Character.isDigit(content.get(i)[0].toCharArray()[0])){
                temp=new Node();
                temp.addLine(content.get(i));
                temp_art.addChild(temp_ust);
                temp.setID(Integer.parseInt(content.get(i)[0].substring(0,content.get(i)[0].length()-2)));
                temp_ust=temp;
                ustepy.add(temp_ust);
                int x=content.get(i+1)[0].length()-1;
                while( !(content.get(i+1)[0].equals("Rozdział") || content.get(i+1)[0].equals("Art.") || content.get(i+1)[0].substring(x,x).equals(")")) || content.get(i+1)[0].substring(x,x).equals(")") ){
                    i++;
                    temp_ust.addLine(content.get(i));
                }
            }
            else if(content.get(i)[0].substring(content.get(i)[0].length()-1,content.get(i)[0].length()-1).equals(")") && content.get(i).length>1 && Character.isDigit(content.get(i)[0].toCharArray()[0])){
                temp=new Node();
                temp.addLine(content.get(i));
                temp_ust.addChild(temp);
                temp.setID(Integer.parseInt(content.get(i)[0].substring(0,content.get(i)[0].length()-2)));
                int x=content.get(i+1)[0].length()-1;
                while( !(content.get(i+1)[0].equals("Rozdział") || content.get(i+1)[0].equals("Art.") || (((content.get(i+1)[0].substring(x,x).equals(")")) || content.get(i+1)[0].substring(x,x).equals(")"))&& Character.isDigit(content.get(i)[0].toCharArray()[0]) )  )){
                    i++;
                    temp.addLine(content.get(i));
                }
            }
            else {temp.addLine(content.get(i));}

        }

    }
    public void view_a(){
        for(int i=0;i<rozdzialy.size();i++){
            rozdzialy.get(i).view();
        }
    }


}
