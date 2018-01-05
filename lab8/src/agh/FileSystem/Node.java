package agh.FileSystem;
import java.util.ArrayList;
import java.util.List;

public class Node {
    public static int id;
    private  String title=null;
    private  List<String[]> content = new ArrayList<String[]>();
    private List<Node> childrens = new ArrayList<Node>();

    public void addLine (String[] line){
        content.add(line);
    }
    public void addChild (Node child){
        childrens.add(child);
    }
    public void setTitle(String tit){this.title=tit;}
    public void setID(int a){this.id=a;}
    public int getID(){return this.id; }


    public void view(){
        System.out.print(title);
        for(int i=0;i<content.size();i++){
            for(int j=0;j<content.get(i).length;j++){
                System.out.print(content.get(i)[j]+" ");
            }
            System.out.print("\n");
        }
        for(int i=0;i<childrens.size();i++){
            childrens.get(i).view();
        }
    }


}
