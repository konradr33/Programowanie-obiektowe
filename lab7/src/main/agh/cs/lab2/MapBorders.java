package agh.cs.lab2;

import java.util.Collection;
import java.util.List;

public class MapBorders {
    private Position lowerLeft;
    private Position upperRight;
    private int xMax,xMin,yMin,yMax;


    public Position getLowerLeft(){
        return this.lowerLeft;
    }

    public Position getUpperRight(){
        return this.upperRight;
    }

    public MapBorders(AbstractWorldMapElement[] that){
        this.xMax=that[0].getPosition().getX();
        this.xMin=that[0].getPosition().getX();
        this.yMax=that[0].getPosition().getY();
        this.yMin=that[0].getPosition().getY();

        for(AbstractWorldMapElement elem : that){
            if(elem.getPosition().getX() > xMax ) { xMax=elem.getPosition().getX(); }
            if(elem.getPosition().getX() < xMin ) { xMin=elem.getPosition().getX(); }
            if(elem.getPosition().getY() > yMax ) { yMax=elem.getPosition().getY(); }
            if(elem.getPosition().getY() < yMin ) { yMin=elem.getPosition().getY(); }
        }

        lowerLeft = new Position(xMin,yMin);
        upperRight = new Position(xMax,yMax);
    }
}
