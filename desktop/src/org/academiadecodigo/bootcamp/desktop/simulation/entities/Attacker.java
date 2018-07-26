package org.academiadecodigo.bootcamp.desktop.simulation.entities;

import org.academiadecodigo.bootcamp.desktop.simulation.fireables.Fireable;

public interface Attacker {

    Fireable getWeapon();

    void setWeapon(Fireable fireable);

    void shoot(Hitable hitObject);


}
