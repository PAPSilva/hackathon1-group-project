package org.academiadecodigo.bootcamp.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import org.academiadecodigo.bootcamp.MyGdxGame;
import org.academiadecodigo.bootcamp.simulation.maps.Map;
import org.academiadecodigo.bootcamp.simulation.maps.MapImpl;
import org.academiadecodigo.bootcamp.views.camera.AbstractCamera;
import org.academiadecodigo.bootcamp.views.camera.GenericCamera;

public class GameScreen extends AbstractScreen implements Screen {

    private MyGdxGame myGdxGame;
    private Map maps;
    private TiledMap map;
    private IsometricTiledMapRenderer renderer;
    private GenericCamera genericCamera;
    private Music gameMusic;

    public GameScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        maps = new MapImpl();
        genericCamera = new GenericCamera();
    }

    @Override
    public void show() {

        map = maps.getMap(0);
        renderer = new IsometricTiledMapRenderer(map);
        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("SuspenseMusic.wav"));
        gameMusic.setLooping(true);
        gameMusic.play();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setView(genericCamera.getCamera());
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

        genericCamera.resize(width,height);
        genericCamera.getCamera().update();
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
