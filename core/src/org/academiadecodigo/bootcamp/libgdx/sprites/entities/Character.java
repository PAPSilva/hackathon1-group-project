package org.academiadecodigo.bootcamp.libgdx.sprites.entities;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import org.academiadecodigo.bootcamp.libgdx.sprites.AbstractSprite;
import org.academiadecodigo.bootcamp.simulation.entities.Direction;
import org.academiadecodigo.bootcamp.simulation.entities.Entity;
import org.academiadecodigo.bootcamp.simulation.projectables.Projectable;

public class Character extends AbstractSprite {

    private Entity entity;

    private Texture texture;
    private String textureFile;
    private Direction oldDirection;
    private RandomAI randomAI = null;


    private String up;
    private String down;
    private String left;
    private String right;


    private AIType aiType = AIType.RANDOM;
    private final int RANDOM_TURN_MAX = 60;
    private final double RANDOM_TURN_AMOUNT = 1.5;


    public Direction getOldDirection() {
        return oldDirection;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    @Override
    public Texture getTexture() {
        return texture;
    }

    @Override
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setTextureFile(String textureFile){
        this.textureFile = textureFile;
        texture = new Texture(Gdx.files.internal(textureFile));
    }

    public void move(Direction direction, double amount) {

        entity.move(direction, amount);
        oldDirection = direction;

        double dx = direction.getX() * amount;
        double dy = direction.getY() * amount;
        //this.translate((float) dx, (float) dy);



        switch (direction) {
            case UP:
                setTextureFile(up);
                break;
            case LEFT:
                setTextureFile(left);
                break;
            case RIGHT:
                setTextureFile(right);
                break;
            case DOWN:
                setTextureFile(down);
        }
    }

    public void setPosition(double x, double y) {

        double dx = x - entity.getX();
        double dy = y - entity.getY();

        move(Direction.RIGHT, dx);
        move(Direction.UP, dy);

        super.setPosition((float) x, (float) y);
    }

    public Rectangle getRectangle() {
        Rectangle rect = getBoundingRectangle();
        rect.setX((float) entity.getX());
        rect.setY((float) entity.getY());

        return rect;
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

    public void setUp(String up) {
        this.up = up;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
