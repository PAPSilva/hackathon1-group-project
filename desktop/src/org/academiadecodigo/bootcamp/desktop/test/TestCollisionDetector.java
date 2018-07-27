package org.academiadecodigo.bootcamp.desktop.test;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class TestCollisionDetector {

    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new org.academiadecodigo.bootcamp.tests.TestEnemyVisualization(), config);
    }

}
