package org.academiadecodigo.bootcamp.libgdx.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.academiadecodigo.bootcamp.libgdx.sprites.entities.Character;
import org.academiadecodigo.bootcamp.libgdx.sprites.projectables.ProjectileFactory;
import org.academiadecodigo.bootcamp.libgdx.sprites.projectables.ProjectileSprite;
import org.academiadecodigo.bootcamp.simulation.entities.Direction;
import org.academiadecodigo.bootcamp.views.camera.GenericCamera;

import java.util.List;

public class Controller {

    private Character character;
    private GenericCamera camera;

    private final double distantAmount = 1.0;

    public void controlEntity(List<ProjectileSprite> projectiles) {

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

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            projectiles.add(attack());
        }

    }

    private void move(Direction direction) {

        // Move character
        character.move(direction, distantAmount);
        character.rotate(direction);

        // Move camera TODO move to camera and invoke method here
        double dx = direction.getX() * distantAmount;
        double dy = direction.getY() * distantAmount;
        camera.getCamera().translate((float) dx, (float) dy);
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setCamera(GenericCamera camera) {
        this.camera = camera;
    }

    public ProjectileSprite attack() {

        double angle = character.getOrientation();
        return ProjectileFactory.create(character.shoot(), character.getX(), character.getY(), Math.cos(angle), Math.sin(angle));
    }
}


