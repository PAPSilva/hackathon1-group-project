package org.academiadecodigo.bootcamp.libgdx.sprites.entities;

import org.academiadecodigo.bootcamp.libgdx.sprites.AbstractSprite;
import org.academiadecodigo.bootcamp.simulation.entities.Direction;
import org.academiadecodigo.bootcamp.simulation.entities.Entity;
import org.academiadecodigo.bootcamp.simulation.projectables.Projectable;

public class Character extends AbstractSprite {

    private Entity entity;

    // TODO implement libgdx

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void move(Direction direction, double amount) {
        entity.move(direction, amount);
    }

    public void setPosition(double x, double y) {

        double dx = x - entity.getX();
        double dy = y - entity.getY();

        move(Direction.RIGHT, dx);
        move(Direction.UP, dy);

        super.setPosition((float) x, (float) y);
    }

    public Projectable shoot() {
        return entity.shoot();
    }

    public void rotate(Direction direction) {
        entity.setOrientation(direction.getAngle());
    }

    public float getX() {
        return (float) entity.getX();
    }

    public float getY() {
        return (float) entity.getY();
    }

    public double getOrientation() {
        return entity.getOrientation();
    }

    public void hit(int damage) {
        entity.hit(damage);
    }

    public boolean isDead() {
        return entity.getHP() == 0;
    }

}
