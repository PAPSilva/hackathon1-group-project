package org.academiadecodigo.bootcamp.tests;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
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
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

public class TestEnemyAI extends ApplicationAdapter {

    private Map maps;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private GenericCamera genericCamera;

    private SpriteBatch batch;
    private Character player;

    private Array<Character> enemies = new Array<Character>();
    private Array<ProjectileSprite> projectiles = new Array<ProjectileSprite>();

    private Controller controller;

    private final int ENEMY_NUMBER = 1;
    private final double MAX_PROJECTILE_DIST = 400000.0;

    @Override
    public void create() {

        maps = new MapImpl();
        genericCamera = new GenericCamera();
        super.create();
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
        controller.controlEntity(projectiles);
        genericCamera.getCamera().update();

        // Draw

        batch.begin();

        batch.draw(player.getTexture(), player.getX(), player.getY());

        for(Character enemy : enemies) {
            enemy.moveAIbased();
            batch.draw(enemy.getTexture(), enemy.getX(), enemy.getY());
        }

        Rectangle projectileRect;
        Rectangle enemyRect;

        Iterator<ProjectileSprite> projectableIterator = projectiles.iterator();
        while(projectableIterator.hasNext()) {

            ProjectileSprite projectile = projectableIterator.next();

            // Check distance ot player and remove if high
            double dx = player.getX() - projectile.getX();
            double dy = player.getY() - projectile.getY();
            if(dx*dx + dy*dy > MAX_PROJECTILE_DIST) {
                projectableIterator.remove();
                continue;
            }

            projectile.move();
            projectileRect = projectile.getBoundingRectangle();
            projectileRect.setPosition(
                    projectile.getX(),
                    projectile.getY()
            );

            Iterator<Character> enemyIterator = enemies.iterator();
            while(enemyIterator.hasNext()) {

                Character enemy = enemyIterator.next();

                enemyRect = enemy.getBoundingRectangle();
                enemyRect.setPosition(
                        (float) enemy.getEntity().getX(),
                        (float) enemy.getEntity().getY()
                );

                if(projectileRect.overlaps(enemyRect)) {

                    enemyIterator.remove();
                    projectableIterator.remove();
                    continue;

                }

            }

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
            enemy.setPosition(
                    player.getEntity().getX(),
                    Math.random() * Gdx.graphics.getHeight()
            );

            enemies.add(enemy);

        }
    }
}
