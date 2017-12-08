package agh.cs.lab2;

abstract class AbstractWorldMapElement {
    protected Position position=new Position(2,2);

    Position getPosition(){
        return this.position;
    }

    String toString(String display) {
        return display;
    }
}
