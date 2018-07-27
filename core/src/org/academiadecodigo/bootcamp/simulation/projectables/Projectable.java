package org.academiadecodigo.bootcamp.simulation.projectables;

import org.academiadecodigo.bootcamp.simulation.entities.Hitable;

public interface Projectable {

    void doDamage(Hitable hitable);

    void setDamage(int damage);

    int getDamage();

    void setDirection(double dx, double dy);

    void setVelocity(double velocity);

    ProjectableType getProjectableType();

    double getDirectionX();

    double getDirectionY();

    double getVelocity();

}
