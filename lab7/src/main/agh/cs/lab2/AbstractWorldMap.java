package agh.cs.lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected List<Car> cars = new ArrayList<>();
    protected Map<Position,AbstractWorldMapElement> mapa=new HashMap<>();


    public boolean canMoveTo(Position position) {
        return !isOccupied(position) ;
    }

    public boolean place(Car elem) throws IllegalArgumentException {
        if (mapa.containsKey( elem.getPosition())) {
            throw new IllegalArgumentException(" Position " + elem.getPosition().toString() + " is already occupied");
        }
        elem.addObserver(this);
        cars.add(elem);

        return mapa.put(elem.getPosition(), elem) != null;
    }

    public void run(MoveDirection[] directions){
        for(int i = 0; i < directions.length; i++){
            cars.get(i%cars.size()).move(directions[i]);
        }
    }

    public boolean isOccupied(Position position){
        return mapa.containsKey(position);
    }

    public Object objectAt(Position position){
        return mapa.get(position);
    }

    public void positionChanged(Position oldPosition, Position newPosition){
        mapa.put(newPosition , mapa.get(oldPosition));
        mapa.remove(oldPosition);
    }
}
