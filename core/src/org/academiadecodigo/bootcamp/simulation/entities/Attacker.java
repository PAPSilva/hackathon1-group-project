package org.academiadecodigo.bootcamp.simulation.entities;

import org.academiadecodigo.bootcamp.simulation.fireables.Firable;
import org.academiadecodigo.bootcamp.simulation.projectables.Projectable;

public interface Attacker {

    Firable getWeapon();

    void setWeapon(Firable firable);

    Projectable shoot();


}
