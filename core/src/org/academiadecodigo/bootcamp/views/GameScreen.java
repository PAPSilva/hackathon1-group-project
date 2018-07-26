package org.academiadecodigo.bootcamp.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import org.academiadecodigo.bootcamp.MyGdxGame;

public class GameScreen extends AbstractScreen implements Screen {

    private MyGdxGame myGdxGame;
    private TiledMap map;
    private IsometricTiledMapRenderer renderer;

    public GameScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {

        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("maps/isometric_grass_and_water.tmx");
        renderer = new IsometricTiledMapRenderer(map);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        renderer.dispose();
        map.dispose();
    }
}
