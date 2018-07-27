package org.academiadecodigo.bootcamp.libgdx.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import org.academiadecodigo.bootcamp.libgdx.sprites.entities.Character;
import org.academiadecodigo.bootcamp.simulation.entities.Direction;
import org.academiadecodigo.bootcamp.views.camera.GenericCamera;

public class Controller {

    private Character character;
    private GenericCamera camera;

    private final double distantAmount = 1.0;

    public void controlCharacter() {

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

        // Move character
        character.move(direction, distantAmount);

        double dx = direction.getX() * distantAmount;
        double dy = direction.getY() * distantAmount;
        camera.getCamera().setToOrtho(false);
        Vector3 vec = (new Vector3(
                (float) character.getEntity().getX(),
                (float) character.getEntity().getY(),
                0.0f)
        );
        camera.getCamera().position.set(vec);
        System.out.println("Entity: " + character.getX() + "," + character.getY());
        System.out.println("Camera: " + camera.getCamera().position.x + "," + camera.getCamera().position.y);
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setCamera(GenericCamera camera) {
        this.camera = camera;
    }
}


