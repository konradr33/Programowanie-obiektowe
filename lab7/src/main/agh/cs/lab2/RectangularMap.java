package agh.cs.lab2;

public class RectangularMap extends AbstractWorldMap {
    public final int width;
    public final int height;

    public RectangularMap (int width, int height){
        super();
        this.width=width;
        this.height=height;
    }

    public boolean canMoveTo(Position position) {
        return position.smaller(new Position(this.width, this.height)) && position.larger(new Position(0, 0)) && super.canMoveTo(position) ;
    }


    public String toString(){
        MapVisualizer visualizer = new MapVisualizer();
        return visualizer.dump(this, new Position(0, 0), new Position(this.width, this.height));
    }
}
