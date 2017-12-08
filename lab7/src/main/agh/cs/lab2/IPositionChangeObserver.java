package agh.cs.lab2;

public interface IPositionChangeObserver {
    void positionChanged(Position oldPosition, Position newPosition);
}
