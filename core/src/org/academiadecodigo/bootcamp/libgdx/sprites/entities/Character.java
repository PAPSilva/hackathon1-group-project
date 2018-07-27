package org.academiadecodigo.bootcamp.libgdx.sprites.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.bootcamp.simulation.entities.Direction;
import org.academiadecodigo.bootcamp.simulation.entities.Entity;
import org.academiadecodigo.bootcamp.libgdx.sprites.entities.AbstractSprite;

public class Character extends AbstractSprite {

    private Entity entity;
    private Texture texture;
    private String textureFile;
    // TODO implement libgdx

    public void setEntity(Entity entity) {
        this.entity = entity;
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
    }

    public void setPosition(double x, double y) {

        double dx = x - entity.getX();
        double dy = y - entity.getY();

        move(Direction.RIGHT, dx);
        move(Direction.UP, dy);

        super.setPosition((float) x, (float) y);
    }
}
