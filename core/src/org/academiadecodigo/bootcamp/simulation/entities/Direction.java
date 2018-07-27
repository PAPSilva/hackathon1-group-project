package org.academiadecodigo.bootcamp.simulation.entities;

public enum Direction {

    UP(0.0, 1.0, Math.PI * 0.5),
    LEFT(-1.0, 0.0, -Math.PI) ,
    DOWN(0.0, -1.0, -Math.PI * 0.5),
    RIGHT(1.0, 0.0, 0.0);

    private double x;
    private double y;
    private double angle;

    Direction(double x, double y, double angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public static Direction getRandom() {
        return values()[ (int) (Math.random() * values().length) ];
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }
}
