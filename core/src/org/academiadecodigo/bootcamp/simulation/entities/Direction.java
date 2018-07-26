package org.academiadecodigo.bootcamp.simulation.entities;

public enum Direction {

    UP(0.0,1.0),
    LEFT(-1.0,0.0),
    DOWN(0.0,-1.0),
    RIGHT(1.0,0.0);

    private double x;
    private double y;

    Direction(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
