package org.academiadecodigo.bootcamp.simulation.entities;

import org.academiadecodigo.bootcamp.simulation.fireables.Firable;
import org.academiadecodigo.bootcamp.simulation.projectables.Projectable;

public abstract class AbstractEntity implements Entity {

    private int hp;
    private int armour;
    private Firable weapon;
    private double x;
    private double y;
    private boolean dead;
    private double orientation;

    // TODO implement


    @Override
    public Firable getWeapon() {
        return weapon;
    }

    @Override
    public void setWeapon(Firable weapon) {
        this.weapon = weapon;
    }

    @Override
    public Projectable shoot() {
        return weapon.fire();
    }

    @Override
    public void hit(int damage) {

        // Deal damage to armour
        int effectiveDamage = hitArmour(damage);

        // Deal damage to hitable
        if(hp > 0 && effectiveDamage > 0) {
            hp -= effectiveDamage;
        }

        hp = hp < 0 ? 0 : hp;
    }

    private int hitArmour(int damage) {

        if(damage <= armour) {
            armour -= damage;
            return 0;
        }

        int carriedDamage = damage - armour;

        armour = 0;

        return carriedDamage;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public int getArmour() {
        return armour;
    }

    @Override
    // TODO refactor variable name to lowercase
    public void setHP(int HPLeft) {
        this.hp = HPLeft;
    }

    @Override
    public void setArmour(int armourLeft) {
        armour = armourLeft;
    }

    @Override
    public void move(Direction direction, double amount) {

        x += direction.getX() * amount;
        y += direction.getY() * amount;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public boolean isDead() {
        return dead;
    }

    @Override
    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }

    @Override
    public double getOrientation() {
        return orientation;
    }
}
