package org.academiadecodigo.bootcamp.simulation.projectables;

import org.academiadecodigo.bootcamp.simulation.entities.Hitable;

public interface Projectable {

    void doDamage(Hitable hitable);

    void setDamage(int damage);

}
