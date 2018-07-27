package org.academiadecodigo.bootcamp.tests;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.bootcamp.libgdx.sprites.entities.Character;

public class TestPlayerVisualization extends ApplicationAdapter {

    SpriteBatch batch;
    private Character player;
    private Character enemy;

    @Override
    public void create () {
        batch = new SpriteBatch();
        player = new Character();
        enemy = new Character();

        player.setTextureFile("hairyMonster.png");
        enemy.setTextureFile("girl.png");
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(player.getTexture(), 0, 0);
        batch.draw(enemy.getTexture(), 200, 200);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        player.getTexture().dispose();
        enemy.getTexture().dispose();
    }

}
