package org.academiadecodigo.bootcamp.tests;

import org.academiadecodigo.bootcamp.simulation.entities.EntityImpl;
import org.academiadecodigo.bootcamp.simulation.entities.Hitable;
import org.academiadecodigo.bootcamp.simulation.entities.Projectable;
import org.academiadecodigo.bootcamp.simulation.entities.Projectile;

public class TestProjectile {

    public static void main(String[] args) {

        Hitable hitable = new EntityImpl();
        hitable.setHP(10);
        hitable.setArmour(0);

        Projectable projectile = new Projectile();

        projectile.setDamage(5);
        projectile.doDamage(hitable);
        System.out.println("HP is " + hitable.getHP() + " and should be 5.");

        projectile.setDamage(6);
        projectile.doDamage(hitable);
        System.out.println("HP is " + hitable.getHP() + " and should be 0.");
    }

}
