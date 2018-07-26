package org.academiadecodigo.bootcamp.simulation.maps;

import com.badlogic.gdx.maps.tiled.TiledMap;

import java.util.LinkedList;
import java.util.List;

public class MapImpl implements Map {

    private List <TiledMap> mapList = new LinkedList<TiledMap>();

    @Override
    public TiledMap getMap(int index) {
        return mapList.get(index);
    }

    @Override
    public void add(TiledMap map) {
         mapList.add(map);
    }

    @Override
    public void remove(int index) {

        mapList.remove(index);

    }
}
