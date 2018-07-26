package org.academiadecodigo.bootcamp.views;

import com.badlogic.gdx.Screen;
import org.academiadecodigo.bootcamp.MyGdxGame;

public class LoadingScreen extends AbstractScreen implements Screen {

    private MyGdxGame myGdxGame;

    public LoadingScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        myGdxGame.changeScreen(ScreenOptions.MENU.getOption());
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
