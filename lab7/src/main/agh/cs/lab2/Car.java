package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class Car extends AbstractWorldMapElement {
    private MapDirection direction = MapDirection.North;
    private IWorldMap cmap;
    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public Car(IWorldMap map) {
        super();
        this.cmap = (IWorldMap) map;
    }

    public Car(IWorldMap map, int x, int y) {
        super();
        this.position = new Position(x, y);
        cmap = (IWorldMap) map;
    }

    public String toString(){
        switch(this.direction) {
            case North:
                return super.toString("⬆");
            case South:
                return super.toString("⬇");
            case East:
                return super.toString("→");
            case West:
                return super.toString("⬅");
            default: return null;
        }
    }

    public void move(MoveDirection moveDirection) {
        Position addPosition = new Position(0, 0);
        switch (direction) {
            case North:
                addPosition = new Position(0, 1);
                break;
            case East:
                addPosition = new Position(1, 0);
                break;
            case South:
                addPosition = new Position(0, -1);
                break;
            case West:
                addPosition = new Position(-1, 0);
                break;
        }
        if (moveDirection == MoveDirection.Forward || moveDirection == MoveDirection.Backward) {
            if (moveDirection == MoveDirection.Backward) {
                addPosition = addPosition.reverse();
            }
            if ( cmap.canMoveTo(this.position.add(addPosition)) ) {
                Position prev=this.position;
                this.position = this.position.add(addPosition);
                this.positionChanged(prev, this.position);

            }
        } else if (moveDirection == MoveDirection.Left) {
            this.direction = direction.previous();
        } else {
            this.direction = direction.next();
        }
    }

    private void positionChanged(Position oldPosition, Position newPosition){
        for(IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition,newPosition);
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
}
