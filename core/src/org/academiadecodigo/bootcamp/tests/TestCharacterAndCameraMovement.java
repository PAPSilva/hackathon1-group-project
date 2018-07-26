package org.academiadecodigo.bootcamp.tests;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import org.academiadecodigo.bootcamp.Controller.Controller;
import org.academiadecodigo.bootcamp.entities.Character;
import org.academiadecodigo.bootcamp.simulation.entities.Entity;
import org.academiadecodigo.bootcamp.simulation.entities.EntityImpl;
import org.academiadecodigo.bootcamp.simulation.maps.Map;
import org.academiadecodigo.bootcamp.simulation.maps.MapImpl;
import org.academiadecodigo.bootcamp.views.camera.GenericCamera;

public class TestCharacterAndCameraMovement extends ApplicationAdapter {

    private Map maps;
    private TiledMap map;
    private IsometricTiledMapRenderer renderer;
    private GenericCamera genericCamera;

    private SpriteBatch batch;
    private Character player;

    private Controller controller;

    @Override
    public void create() {

        maps = new MapImpl();
        genericCamera = new GenericCamera();
        super.create();
        map = maps.getMap(0);
        renderer = new IsometricTiledMapRenderer(map);

        batch = new SpriteBatch();
        player = new Character();
        Entity playertEntity = new EntityImpl();
        player.setEntity(playertEntity);
        player.setTextureFile("hairyMonster.png");

        // Center on camera
        System.out.println(
                "Camera before " + genericCamera.getCamera().position.x + ","
                        + genericCamera.getCamera().position.y
        );
        genericCamera.getCamera().position.set(
                (float) (playertEntity.getX() - Gdx.graphics.getWidth()*0.5),
                (float) (playertEntity.getY() - Gdx.graphics.getHeight()*0.5),
                genericCamera.getCamera().position.z);
        System.out.println(
                "Camera after " + genericCamera.getCamera().position.x + ","
                        + genericCamera.getCamera().position.y
        );


        controller = new Controller();
        controller.setCharacter(player);
        controller.setCamera(genericCamera);

        // Test set position of character


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
        //cameraController(genericCamera.getCamera());
        controller.controlEntity();
        genericCamera.getCamera().update();

        batch.begin();
        batch.draw(player.getTexture(), 0, 0);
        batch.end();

        super.render();
    }

    @Override
    public void dispose() {

        renderer.dispose();
        map.dispose();
        super.dispose();
    }

}
