package org.academiadecodigo.bootcamp.simulation.fireables;

import org.academiadecodigo.bootcamp.simulation.projectables.Projectable;
import org.academiadecodigo.bootcamp.simulation.projectables.ProjectableType;

public interface Firable {

    void setAmmo(int ammoAmount);

    int getAmmo();

    Projectable fire();

    void setProjectableType(ProjectableType projectableType);

}
