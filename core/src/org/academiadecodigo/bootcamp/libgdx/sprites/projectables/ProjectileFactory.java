package org.academiadecodigo.bootcamp.libgdx.sprites.projectables;

import org.academiadecodigo.bootcamp.simulation.projectables.Projectable;

public class ProjectileFactory {

    public static ProjectileSprite create(Projectable projectable, double x, double y, double directionX, double directionY) {

        final double muzzleDist = 5.0;

        ProjectileSprite projectileSprite = new ProjectileSprite();

        if(projectable == null) {
            System.out.println("NULL!");
        }
        projectable.setDirection(directionX, directionY);
        projectileSprite.setProjectile(projectable);

        projectileSprite.setTextureFile(
                ProjectileSpriteTypes.get(projectable.getProjectableType()).getTextureFile()
        );
        projectileSprite.rotate( (float) Math.atan2(projectable.getDirectionY(), projectable.getDirectionX()));

        projectileSprite.setPosition(
                (float) (x + directionX * muzzleDist + projectileSprite.getWidth()),
                (float) (y + directionY * muzzleDist + projectileSprite.getHeight()));

        return projectileSprite;

    }

}
