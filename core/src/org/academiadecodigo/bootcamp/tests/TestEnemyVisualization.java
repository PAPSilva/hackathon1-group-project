package org.academiadecodigo.bootcamp.tests;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.bootcamp.libgdx.sprites.entities.Character;
import org.academiadecodigo.bootcamp.libgdx.sprites.projectables.ProjectileFactory;
import org.academiadecodigo.bootcamp.simulation.projectables.Projectile;

import java.util.Iterator;

public class TestEnemyVisualization extends ApplicationAdapter {

    private float spriteXposition;
    private float spriteYposition;

    SpriteBatch batch;
    private Character player, enemy;
    private Array<Character> enemies;
    private Array <Rectangle> bullets;
    private long lastBulletTime;
    private Rectangle bullet;
    private Texture bulletImage;

    private ProjectileFactory factory;

    @Override
    public void create () {
        batch = new SpriteBatch();
        player = new Character();
        enemy = new Character();
        enemy.setTextureFile("girl.jpg");
        enemies = new Array<Character>();

        bullets = new Array<Rectangle>();
        enemies.add(enemy);

        //Changed here the instantiation
        bulletImage = new Texture(Gdx.files.internal("bullet-31.png"));

        player.setTextureFile("hairyMonster.png");

    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(player.getTexture(), 0, 0);
        batch.draw(enemies.get(0).getTexture(), 200, 200);

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if (TimeUtils.nanoTime() - lastBulletTime > 1000000) {
                spawBullet();
            }
        }

        Character enemy;
        Iterator<Character> iterEnemies = enemies.iterator();

        while(iterEnemies.hasNext()) {

            enemy = iterEnemies.next();

            Iterator<Rectangle> iterBullets = bullets.iterator();

            while (iterBullets.hasNext()) {
                bullet = iterBullets.next();

                if (bullet.overlaps(enemy.getBoundingRectangle())) {
                    iterBullets.remove();


                    iterEnemies.remove();
                    break;
                }
            }
        }

        for (Rectangle bullet2 : bullets){
            batch.draw(bulletImage, (bullet2.x), (bullet2.y) += 10, 25, 25);
        }



        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        player.getTexture().dispose();
        enemy .getTexture().dispose();
    }

    public void spawBullet() {
        Rectangle bullet = new Rectangle();
        bullet.x = spriteXposition;
        bullet.y = spriteYposition;
        bullet.width = 30;
        bullet.height = 30;
        bullets.add(bullet);
        lastBulletTime = TimeUtils.nanoTime();
    }
}
