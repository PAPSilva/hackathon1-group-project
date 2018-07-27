package org.academiadecodigo.bootcamp.simulation.projectables;

public enum ProjectableType {

    BULLET(10, 10.0);

    private int damage;
    private double velocity;

    ProjectableType(int damage, double velocity) {
        this.damage = damage;
        this.velocity = velocity;
    }

    public int getDamage() {
        return damage;
    }

    public double getVelocity() {
        return velocity;
    }
}
