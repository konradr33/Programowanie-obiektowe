package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    public UnboundedMap (List<?extends AbstractWorldMapElement> elements) throws IllegalArgumentException {
        super();
        for (AbstractWorldMapElement element : elements) {
            if (mapa.containsKey(element.getPosition())) {
                throw new IllegalArgumentException(" Position " + element.getPosition().toString() + " is already occupied");
            }
            mapa.put(element.getPosition(), element);
        }
    }



    public String toString(){
        AbstractWorldMapElement[] elements=mapa.values().toArray(new AbstractWorldMapElement[0]);
        MapBorders border = new MapBorders(elements);
        MapVisualizer visualizer = new MapVisualizer();
        return visualizer.dump(this, border.getLowerLeft(), border.getUpperRight() );
    }
}
