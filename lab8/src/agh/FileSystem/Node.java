package agh.FileSystem;
import java.util.ArrayList;
import java.util.List;

public class Node {
    public static int id;
    private  String title="";
    private  List<String[]> describtion = new ArrayList<String[]>();
    private  List<String[]> content = new ArrayList<String[]>();
    private List<Node> childrens = new ArrayList<Node>();

    public void addLine (String[] line){
        content.add(line);
    }
    public void addDescribtion (String[] line){
        describtion.add(line);
    }
    public void addChild (Node child){
        childrens.add(child);
    }
    public List<Node> getChildren(){return childrens;}
    public void setTitle(String tit){this.title=tit;}
    public void setID(int a){this.id=a;}
    public int getIDInt(){return id;}
    public String getID(){
        if(content.get(0).length>1){
            return content.get(0)[0]+" "+content.get(0)[1];
        } else return "";
    }
    public String getTitle(){
        return this.title;
    }

    public void single_view() {
        if (!(title.length() == 0)) {
            System.out.print("\n");
            System.out.print(title + "\n");
        }
        for (int i = 0; i < describtion.size(); i++) {
            for (int j = 0; j < describtion.get(i).length; j++) {
                if (!(describtion.get(i)[j].length() == 0)) {
                    System.out.print(describtion.get(i)[j] + " ");
                }
            }
            System.out.print("\n");
        }
}

    public void view_a(){
        if (!(title.length() == 0)) {
            System.out.print("\n");
            System.out.print(title + "\n");
        }
        for (int i = 0; i < describtion.size(); i++) {
            for (int j = 0; j < describtion.get(i).length; j++) {
                if (!(describtion.get(i)[j].length() == 0)) {
                    System.out.print(describtion.get(i)[j] + " ");
                }
            }
            System.out.print("\n");
        }
        for(int i=0;i<content.size();i++){
            for(int j=0;j<content.get(i).length;j++){
                if(! (content.get(i)[j].length()==0)){
                    System.out.print(content.get(i)[j]+" ");
                }
            }
            System.out.print("\n");
        }
        if(childrens.isEmpty()) return;
        for(int i=0;i<childrens.size();i++){
            childrens.get(i).view_a();
        }
    }




}
