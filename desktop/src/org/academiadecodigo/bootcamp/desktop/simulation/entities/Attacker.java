package org.academiadecodigo.bootcamp.desktop.simulation.entities;

import org.academiadecodigo.bootcamp.desktop.simulation.fireables.Firable;

public interface Attacker {

    Firable getWeapon();

    void setWeapon(Firable firable);

    void shoot(Hitable hitObject);


}
