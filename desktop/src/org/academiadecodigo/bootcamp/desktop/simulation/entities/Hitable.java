package org.academiadecodigo.bootcamp.desktop.simulation.entities;

public interface Hitable {

    public void hit(int damage);

    public int getHP();

    public int getArmour();

    public void setHP(int HPLeft);

    public void setArmour(int armourLeft);
}
