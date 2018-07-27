package org.academiadecodigo.bootcamp.desktop.test;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.bootcamp.tests.TestCharacterShooting;

public class TestCharacterShootingMain {

    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new TestCharacterShooting());
    }
}
