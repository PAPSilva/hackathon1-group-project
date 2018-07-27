package org.academiadecodigo.bootcamp.libgdx.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class AbstractSprite extends Sprite {

    private Texture texture;

    //Put as a local variable???
    private String textureFile;


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



}
