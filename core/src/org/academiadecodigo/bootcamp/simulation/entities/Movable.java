package org.academiadecodigo.bootcamp.simulation.entities;

public interface Movable {

    void move(Direction direction, double amount);

    double getX();

    double getY();

}
