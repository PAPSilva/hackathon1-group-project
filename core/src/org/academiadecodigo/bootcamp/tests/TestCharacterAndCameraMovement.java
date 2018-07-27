package org.academiadecodigo.bootcamp.tests;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.bootcamp.libgdx.controller.Controller;
import org.academiadecodigo.bootcamp.libgdx.sprites.entities.Character;
import org.academiadecodigo.bootcamp.simulation.entities.Direction;
import org.academiadecodigo.bootcamp.simulation.entities.Entity;
import org.academiadecodigo.bootcamp.simulation.entities.EntityImpl;
import org.academiadecodigo.bootcamp.simulation.maps.Map;
import org.academiadecodigo.bootcamp.simulation.maps.MapImpl;
import org.academiadecodigo.bootcamp.views.camera.GenericCamera;

public class TestCharacterAndCameraMovement extends ApplicationAdapter {

    private Map maps;
    private TiledMap map;
    //private IsometricTiledMapRenderer renderer;
    private OrthogonalTiledMapRenderer renderer;
    private GenericCamera genericCamera;

    private SpriteBatch batch;
    private Character player;

    private Controller controller;

    double oldX;
    double oldY;

    @Override
    public void create() {

        maps = new MapImpl();
        genericCamera = new GenericCamera();
        super.create();
        map = maps.getMap(0);
        //renderer = new IsometricTiledMapRenderer(map);
        renderer = new OrthogonalTiledMapRenderer(map);

        batch = new SpriteBatch();
        player = new Character();
        Entity playertEntity = new EntityImpl();
        player.setEntity(playertEntity);
        player.setTextureFile("hairyMonster.png");

        // Center charater on camera
        player.setPosition(
                Gdx.graphics.getWidth()*0.5 - player.getTexture().getWidth()*0.5,
                Gdx.graphics.getHeight()*0.5 - player.getTexture().getHeight()*0.5
        );

        controller = new Controller();
        controller.setCharacter(player);
        controller.setCamera(genericCamera);

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

        int layer = 1;
        Rectangle playerRect = player.getBoundingRectangle();




        renderer.setView(genericCamera.getCamera());
        renderer.render();
        controller.controlEntity(null);
        genericCamera.getCamera().update();

        for (RectangleMapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)) {

            Rectangle rect = ((object).getRectangle());

            if (player.getRectangle().overlaps(rect)) {
                switch(player.getOldDirection()){
                    case UP:player.move(Direction.DOWN,5.00);
                        break;
                    case DOWN:player.move(Direction.UP,5.00);
                        break;
                    case LEFT:player.move(Direction.RIGHT,5.00);
                        break;
                    case RIGHT:player.move(Direction.LEFT,5.00);
                        break;
                }

            }
        }

        batch.begin();
        batch.draw(player.getTexture(), player.getX(), player.getY());
        oldX = player.getRectangle().getX();
        oldY = player.getRectangle().getY();
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
