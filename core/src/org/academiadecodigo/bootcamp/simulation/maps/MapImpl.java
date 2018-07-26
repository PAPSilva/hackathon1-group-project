package org.academiadecodigo.bootcamp.simulation.maps;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.util.LinkedList;
import java.util.List;

public class MapImpl implements Map {

    private List <TiledMap> mapList = new LinkedList<TiledMap>();

    public MapImpl(){

        TmxMapLoader loader = new TmxMapLoader();
        TiledMap map = loader.load("maps/isometric_grass_and_water.tmx");
        add(map);

    }

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
