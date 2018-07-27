package org.academiadecodigo.bootcamp.simulation.entities;

public interface Hitable {

    void hit(int damage);

    int getHP();

    int getArmour();

    void setHP(int HPLeft);

    void setArmour(int armourLeft);
}
