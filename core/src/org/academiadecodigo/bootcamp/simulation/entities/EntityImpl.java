package org.academiadecodigo.bootcamp.simulation.entities;

import com.sun.javafx.scene.traversal.Direction;
import org.academiadecodigo.bootcamp.simulation.fireables.Firable;

public class EntityImpl extends AbstractEntity {
    @Override
    public Firable getWeapon() {
        return null;
    }

    @Override
    public void setWeapon(Firable firable) {

    }

    @Override
    public void shoot(Hitable hitObject) {

    }

    @Override
    public void hit(int damage) {

    }

    @Override
    public int getHP() {
        return 0;
    }

    @Override
    public int getArmour() {
        return 0;
    }

    @Override
    public void setHP(int HPLeft) {

    }

    @Override
    public void setArmour(int armourLeft) {

    }

    @Override
    public void move(Direction direction, int amount) {

    }

    // Methods are implemented, for now, in the abstract entity
}
