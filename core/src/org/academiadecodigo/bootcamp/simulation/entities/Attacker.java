package org.academiadecodigo.bootcamp.simulation.entities;

import org.academiadecodigo.bootcamp.simulation.fireables.Firable;

public interface Attacker {

    Firable getWeapon();

    void setWeapon(Firable firable);

    void shoot(Hitable hitObject);


}
