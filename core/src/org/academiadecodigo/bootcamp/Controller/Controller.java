package org.academiadecodigo.bootcamp.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.academiadecodigo.bootcamp.simulation.entities.Entity;
import org.academiadecodigo.bootcamp.simulation.entities.Direction;
import org.academiadecodigo.bootcamp.simulation.entities.Hitable;
import org.academiadecodigo.bootcamp.views.camera.GenericCamera;

public class Controller {

    private Entity entity;
    private GenericCamera camera;

    private final double distantAmount = 1.0;

    public void controlEntity() {

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            move(Direction.UP);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            move(Direction.DOWN);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            move(Direction.RIGHT);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            move(Direction.LEFT);
        }
    }

    private void move(Direction direction) {

        // Move entity
        entity.move(direction, distantAmount);

        // Move camera TODO move to camera and invoke method here
        double dx = direction.getX() * distantAmount;
        double dy = direction.getY() * distantAmount;
        camera.getCamera().translate((float) dx, (float) dy);
    }

    // TODO review this method
    public void controlEntity(Hitable hitObject) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            entity.shoot(hitObject);
        }
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void setCamera(GenericCamera camera) {
        this.camera = camera;
    }
}


