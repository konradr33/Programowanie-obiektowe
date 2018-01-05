package agh.FileSystem;
import java.util.ArrayList;
import java.util.List;

public class Node {
    public static int id;
    private  String title;
    private  List<String[]> describtion = new ArrayList<String[]>();
    private  List<String[]> content = new ArrayList<String[]>();
    private List<Node> childrens = new ArrayList<Node>();

    public void addLine (String[] line){
        content.add(line);
    }
    public void addChild (Node child){
        childrens.add(child);
    }
    public void addDescribtion(String[] desc){describtion.add(desc);}
    public void setTitle(String tit){this.title=tit;}
    public void setID(int a){this.id=a;}

    public void toString(String sign){
        for(int i=0;i<content.size();i++){
            for(int j=0;j<content.get(i).length;j++){
                System.out.print(content.get(i)[j]+" ");
            }
            System.out.print(sign);
        }
    }


}
