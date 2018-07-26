package org.academiadecodigo.bootcamp.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.academiadecodigo.bootcamp.simulation.entities.Entity;
import org.academiadecodigo.bootcamp.entities.Direction;
import org.academiadecodigo.bootcamp.simulation.entities.Hitable;

public class Controller {

    private Entity entity;

    private final double distantAmount = 1.0;

    public void controlEntity() {

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            entity.move(Direction.UP, distantAmount);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            entity.move(Direction.DOWN, distantAmount);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            entity.move(Direction.RIGHT, distantAmount);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            entity.move(Direction.LEFT, distantAmount);
        }
    }

    public void controlEntity(Hitable hitObject) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            entity.shoot(hitObject);
        }
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}


