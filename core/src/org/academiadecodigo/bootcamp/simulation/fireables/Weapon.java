package org.academiadecodigo.bootcamp.simulation.fireables;

import org.academiadecodigo.bootcamp.simulation.projectables.Projectable;
import org.academiadecodigo.bootcamp.simulation.projectables.ProjectableType;
import org.academiadecodigo.bootcamp.simulation.projectables.Projectile;

public class Weapon implements Firable {

    private ProjectableType projectableType;
    private int ammo;

    @Override
    public void setAmmo(int ammoAmount) {
        ammo = ammoAmount;
    }

    @Override
    public int getAmmo() {
        return ammo;
    }

    @Override
    public Projectable fire() {

        if(ammo == 0) {
            return null;
        }

        Projectable projectile = new Projectile();
        projectile.setDamage(projectableType.getDamage());
        ((Projectile) projectile).setProjectableType(projectableType); // TODO why the casting?
        projectile.setVelocity(projectableType.getVelocity());
        ammo--;

        return projectile;
    }

    @Override
    public void setProjectableType(ProjectableType projectableType) {
        this.projectableType = projectableType;
    }
}
