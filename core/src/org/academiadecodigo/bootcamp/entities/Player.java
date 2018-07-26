package org.academiadecodigo.bootcamp.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import org.academiadecodigo.bootcamp.simulation.entities.Entity;

public class Player extends Sprite {

    private Entity entity;
    private Texture texture;
    private String textureFile;
    // TODO implement libgdx


    public Entity getEntity() {
        return entity;
    }

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

    public String getTextureFile() {
        return textureFile;
    }

}
