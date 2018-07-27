package org.academiadecodigo.bootcamp.simulation.fireables;

import org.academiadecodigo.bootcamp.simulation.projectables.Projectable;
import org.academiadecodigo.bootcamp.simulation.projectables.ProjectableType;
import org.academiadecodigo.bootcamp.simulation.projectables.Projectile;

public class Weapon implements Firable {

    private ProjectableType projectableType;
    private int ammo;
    private int damage;

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
        Projectable projectile = new Projectile();
        projectile.setDamage(projectableType.getDamage());
        return new Projectile();
    }

    @Override
    public void setProjectableType(ProjectableType projectableType) {
        this.projectableType = projectableType;
    }
}
