package org.academiadecodigo.bootcamp.views.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by codecadet on 7/26/2018 AD.
 */
public abstract class AbstractCamera {

    private OrthographicCamera camera;

    public AbstractCamera(){

        this.camera = new OrthographicCamera();

    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void resize(int height, int width){

        camera.viewportHeight = height;
        camera.viewportWidth = width;
    }

    public double getWidth() {
        return camera.viewportWidth;
    }

    public double getHeight() {
        return camera.viewportHeight;
    }
}
