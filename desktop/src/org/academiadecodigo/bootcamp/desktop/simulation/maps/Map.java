package org.academiadecodigo.bootcamp.desktop.simulation.maps;

import com.badlogic.gdx.maps.tiled.TiledMap;

public interface Map {

    TiledMap getMap (int index);
    void add();
    void remove();

}
