package org.academiadecodigo.bootcamp.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.bootcamp.MyGdxGame;
import org.academiadecodigo.bootcamp.libgdx.controller.Controller;
import org.academiadecodigo.bootcamp.libgdx.sprites.entities.Character;
import org.academiadecodigo.bootcamp.libgdx.sprites.projectables.ProjectileSprite;
import org.academiadecodigo.bootcamp.simulation.entities.Direction;
import org.academiadecodigo.bootcamp.simulation.entities.Entity;
import org.academiadecodigo.bootcamp.simulation.entities.EntityImpl;
import org.academiadecodigo.bootcamp.simulation.fireables.Firable;
import org.academiadecodigo.bootcamp.simulation.fireables.Weapon;
import org.academiadecodigo.bootcamp.simulation.maps.Map;
import org.academiadecodigo.bootcamp.simulation.maps.MapImpl;
import org.academiadecodigo.bootcamp.simulation.projectables.ProjectableType;
import org.academiadecodigo.bootcamp.views.camera.AbstractCamera;
import org.academiadecodigo.bootcamp.views.camera.GenericCamera;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends AbstractScreen implements Screen {

    private Map maps;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private GenericCamera genericCamera;
    MyGdxGame myGdxGame;

    private SpriteBatch batch;
    private Character player;

    private List<Character> enemies = new ArrayList<Character>();
    private List<ProjectileSprite> projectiles = new ArrayList<ProjectileSprite>();

    private Controller controller;

    private final int ENEMY_NUMBER = 10;

    public GameScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        maps = new MapImpl();
        genericCamera = new GenericCamera();
    }



    @Override
    public void show() {

        maps = new MapImpl();
        genericCamera = new GenericCamera();
        map = maps.getMap(0);
        renderer = new OrthogonalTiledMapRenderer(map);

        batch = new SpriteBatch();
        player = new Character();
        Entity playertEntity = new EntityImpl();
        Firable weapon = new Weapon();
        weapon.setProjectableType(ProjectableType.BULLET);
        weapon.setAmmo(5000);
        playertEntity.setWeapon(weapon);
        player.setEntity(playertEntity);
        player.setTextureFile("player/player_front.png");
        player.setUp("player/player_back.png");
        player.setLeft("player/player_leftside.png");
        player.setRight("player/player_rightside.png");
        player.setDown("player/player_front.png");

        // Center character on camera
        player.setPosition(
                Gdx.graphics.getWidth()*0.5 - player.getTexture().getWidth()*0.5,
                Gdx.graphics.getHeight()*0.5 - player.getTexture().getHeight()*0.5
        );

        controller = new Controller();
        controller.setCharacter(player);
        controller.setCamera(genericCamera);

        spawnEnemiesRandom();

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setView(genericCamera.getCamera());
        renderer.render();
        controller.controlEntity(projectiles);
        genericCamera.getCamera().update();

        // Draw

        batch.begin();

        batch.draw(player.getTexture(), player.getX(), player.getY());

        for(Character enemy : enemies) {
            enemy.moveAIbased();
            batch.draw(enemy.getTexture(), enemy.getX(), enemy.getY());
        }

        for(ProjectileSprite projectile : projectiles) {
            projectile.move();
            batch.draw(projectile.getTexture(), projectile.getX(), projectile.getY());
        }

        batch.end();
        super.render(delta);
    }

    private void spawnEnemiesRandom() {

        for(int i=0; i < ENEMY_NUMBER; i++) {

            Character enemy = new Character();
            Entity enemyEntity = new EntityImpl();
            Firable weapon = new Weapon();
            weapon.setProjectableType(ProjectableType.BULLET);
            weapon.setAmmo(5000);
            enemyEntity.setWeapon(weapon);
            enemy.setEntity(enemyEntity);
            enemy.setTextureFile("enemy/enemy_front.png");
            enemy.setUp("enemy/enemy_back.png");
            enemy.setLeft("enemy/enemy_leftside.png");
            enemy.setRight("enemy/enemy_rightside.png");
            enemy.setDown("enemy/enemy_front.png");

            enemy.setPosition(
                    Math.random() * Gdx.graphics.getWidth(),
                    Math.random() * Gdx.graphics.getHeight()
            );

            enemies.add(enemy);

        }
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
        gameMusic.stop();
    }
}
