package org.academiadecodigo.bootcamp.libgdx.sprites.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.bootcamp.simulation.entities.Direction;
import org.academiadecodigo.bootcamp.simulation.entities.Entity;
import org.academiadecodigo.bootcamp.libgdx.sprites.entities.AbstractSprite;

public class Character extends AbstractSprite {

    private Entity entity;
    private Texture texture;
    private String textureFile;
    private Direction oldDirection;
    // TODO implement libgdx


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

}
