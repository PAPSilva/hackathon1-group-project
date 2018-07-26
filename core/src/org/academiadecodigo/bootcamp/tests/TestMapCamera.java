package org.academiadecodigo.bootcamp.tests;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import org.academiadecodigo.bootcamp.simulation.maps.Map;
import org.academiadecodigo.bootcamp.simulation.maps.MapImpl;
import org.academiadecodigo.bootcamp.views.camera.GenericCamera;

/**
 * Created by codecadet on 7/26/2018 AD.
 */
public class TestMapCamera extends ApplicationAdapter {

    private Map maps;
    private TiledMap map;
    private IsometricTiledMapRenderer renderer;
    private GenericCamera genericCamera;



    @Override
    public void create() {

        maps = new MapImpl();
        genericCamera = new GenericCamera();
        super.create();
        map = maps.getMap(0);
        renderer = new IsometricTiledMapRenderer(map);
    }

    @Override
    public void resize(int width, int height) {


        genericCamera.resize(width,height);
        genericCamera.getCamera().update();
        super.resize(width, height);
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setView(genericCamera.getCamera());
        renderer.render();
        cameraController(genericCamera.getCamera());
        genericCamera.getCamera().update();

        super.render();
    }

    private void cameraController(Camera camera){

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            camera.translate(0, 10, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            camera.translate(0, -10, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            camera.translate(-10, 0, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            camera.translate(10, 0, 0);
        }
    }

    @Override
    public void dispose() {

        renderer.dispose();
        map.dispose();
        super.dispose();
    }
}
