package org.academiadecodigo.bootcamp.libgdx.sprites.projectables;

import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.bootcamp.libgdx.sprites.AbstractSprite;
import org.academiadecodigo.bootcamp.libgdx.sprites.entities.Character;
import org.academiadecodigo.bootcamp.simulation.projectables.Projectable;

public class ProjectileSprite extends AbstractSprite {

    private Projectable projectile;

    public void setProjectile(Projectable projectile) {
        this.projectile = projectile;
    }

    public void move() {
        this.translate(
                (float) (projectile.getDirectionX() * projectile.getVelocity()),
                (float) (projectile.getDirectionY() * projectile.getVelocity())
        );

    }

    public void hit(Character character) {
        character.hit(projectile.getDamage());
    }

}
