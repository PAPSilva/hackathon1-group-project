package org.academiadecodigo.bootcamp.simulation.projectables;

public enum ProjectableType {

    BULLET(10);

    private int damage;

    ProjectableType(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
