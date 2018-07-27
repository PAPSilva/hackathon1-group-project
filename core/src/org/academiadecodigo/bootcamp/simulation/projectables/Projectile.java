package org.academiadecodigo.bootcamp.simulation.projectables;

import org.academiadecodigo.bootcamp.simulation.entities.Hitable;

public class Projectile implements Projectable {

    private int damage;
    private double directionX;
    private double directionY;
    private double velocity;
    private ProjectableType projectableType;

    @Override
    public void doDamage(Hitable hitable) {
        hitable.hit(damage);
    }


    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void setDirection(double dx, double dy) {
        this.directionX = dx;
        this.directionY = dy;
    }

    @Override
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    @Override
    public ProjectableType getProjectableType() {
        return projectableType;
    }

    public void setProjectableType(ProjectableType projectableType) {
        this.projectableType = projectableType;
    }

    @Override
    public double getDirectionX() {
        return directionX;
    }

    @Override
    public double getDirectionY() {
        return directionY;
    }

    @Override
    public double getVelocity() {
        return velocity;
    }
}
