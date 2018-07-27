package org.academiadecodigo.bootcamp.libgdx.sprites.entities;

import org.academiadecodigo.bootcamp.libgdx.sprites.AbstractSprite;
import org.academiadecodigo.bootcamp.simulation.entities.Direction;
import org.academiadecodigo.bootcamp.simulation.entities.Entity;
import org.academiadecodigo.bootcamp.simulation.projectables.Projectable;

public class Character extends AbstractSprite {

    private Entity entity;
    private RandomAI randomAI = null;

    private AIType aiType = AIType.RANDOM;
    private final int RANDOM_TURN_MAX = 6000;
    private final double RANDOM_TURN_AMOUNT = 1.5;

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


    public double getOrientation() {
        return entity.getOrientation();
    }

    public void hit(int damage) {
        entity.hit(damage);
    }

    public boolean isDead() {
        return entity.getHP() == 0;
    }

    public void moveAIbased() {

        switch (aiType) {
            case RANDOM:
                moveRandom();
                break;
            case FOLLOW:
                // TODO
                break;
        }
    }

    private void moveRandom() {

        if (randomAI == null) {

            randomAI = new RandomAI(RANDOM_TURN_MAX);

        }

        randomAI.act();
        translate(
                (float) (randomAI.getDirection().getX() * RANDOM_TURN_AMOUNT),
                (float) (randomAI.getDirection().getY() * RANDOM_TURN_AMOUNT)
        );
        move(randomAI.getDirection(), RANDOM_TURN_AMOUNT);

    }

    private class RandomAI {

        private int maxTurns;
        private int turns;
        private Direction direction;

        public RandomAI(int turns) {
            this.maxTurns = turns;
            this.direction = Direction.getRandom();
        }

        private void act() {

            if(turns > 0) {
                turns--;
                return;
            }

            randomTurns();
            direction = Direction.getRandom();
        }

        private void randomTurns() {
            turns = (int) (Math.random() * maxTurns) + 1;
        }

        public Direction getDirection() {
            return direction;
        }
    }

    public Entity getEntity() {
        return entity;
    }
}
