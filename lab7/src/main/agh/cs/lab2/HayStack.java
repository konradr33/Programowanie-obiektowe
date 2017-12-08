package agh.cs.lab2;

public class HayStack extends AbstractWorldMapElement{


    public HayStack(Position prefered) {
        super();
        this.position=prefered;
    }

    public String toString() {
        return super.toString("S");
    }
}
