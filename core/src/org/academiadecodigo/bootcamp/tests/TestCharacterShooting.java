package org.academiadecodigo.bootcamp.tests;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.utils.Array;
import org.academiadecodigo.bootcamp.libgdx.controller.Controller;
import org.academiadecodigo.bootcamp.libgdx.sprites.entities.Character;
import org.academiadecodigo.bootcamp.libgdx.sprites.projectables.ProjectileSprite;
import org.academiadecodigo.bootcamp.simulation.entities.Entity;
import org.academiadecodigo.bootcamp.simulation.entities.EntityImpl;
import org.academiadecodigo.bootcamp.simulation.fireables.Firable;
import org.academiadecodigo.bootcamp.simulation.fireables.Weapon;
import org.academiadecodigo.bootcamp.simulation.maps.Map;
import org.academiadecodigo.bootcamp.simulation.maps.MapImpl;
import org.academiadecodigo.bootcamp.simulation.projectables.ProjectableType;
import org.academiadecodigo.bootcamp.views.camera.GenericCamera;

public class TestCharacterShooting extends ApplicationAdapter {

    private Map maps;
    private TiledMap map;
    private IsometricTiledMapRenderer renderer;
    private GenericCamera genericCamera;

    private SpriteBatch batch;
    private Character player;

    private Array<Character> enemies = new Array<Character>();
    private Array<ProjectileSprite> projectiles = new Array<ProjectileSprite>();

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
        Firable weapon = new Weapon();
        weapon.setProjectableType(ProjectableType.BULLET);
        weapon.setAmmo(5000);
        playertEntity.setWeapon(weapon);
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

        renderer.setView(genericCamera.getCamera());
        renderer.render();
        //cameraController(genericCamera.getCamera());
        controller.controlEntity(projectiles);
        genericCamera.getCamera().update();

        batch.begin();
        batch.draw(player.getTexture(), player.getX(), player.getY());
        for(ProjectileSprite projectile : projectiles) {
            projectile.move();
            batch.draw(projectile.getTexture(), projectile.getX(), projectile.getY());
        }
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
