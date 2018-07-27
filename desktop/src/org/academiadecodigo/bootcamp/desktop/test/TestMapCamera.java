package org.academiadecodigo.bootcamp.desktop.test;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.bootcamp.tests.TestPlayerVisualization;

/**
 * Created by codecadet on 7/26/2018 AD.
 */
public class TestMapCamera {

    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new org.academiadecodigo.bootcamp.tests.TestMapCamera(), config);
    }


}
