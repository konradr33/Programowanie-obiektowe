package agh.cs.lab2;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString () {
        return "("+this.x+","+this.y+")";
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public boolean smaller (Position a) {
        return (this.x<=a.x && this.y<=a.y);
    }

    public boolean larger (Position a) {
        return (this.x>=a.x && this.y>=a.y);
    }

    public Position add (Position a) {
        return new Position (this.x+a.x ,this.y+a.y );
    }

    public Position reverse() { return new Position(-this.x,-this.y); }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean equals (Object other){
        if (this == other)
            return true;
        if (!(other instanceof Position))
            return false;
        Position that = (Position) other;
        return (this.x==that.x && this.y==that.y);
    }

}
