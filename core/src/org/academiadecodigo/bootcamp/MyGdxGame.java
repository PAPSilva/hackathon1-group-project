package org.academiadecodigo.bootcamp;

import com.badlogic.gdx.Game;
import org.academiadecodigo.bootcamp.views.*;

import java.util.HashMap;
import java.util.Map;

public class MyGdxGame extends Game {

	private LoadingScreen loadingScreen;
	private Map<Integer, AbstractScreen> screenMap;



	@Override
	public void create() {

		createScreenMap();

		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
	}

	public void changeScreen(int screen) {

		AbstractScreen abstractScreen = screenMap.get(screen);

		if (abstractScreen == null) {
			abstractScreen = screenMap.get(screen);
		}
		this.setScreen(abstractScreen);
	}

	private void createScreenMap() {

		screenMap = new HashMap<Integer, AbstractScreen>();
		screenMap.put(ScreenOptions.MENU.getOption(), new MenuScreen(this));
		screenMap.put(ScreenOptions.PREFERENCES.getOption(), new PreferencesScreen(this));
		screenMap.put(ScreenOptions.APPLICATION.getOption(), new GameScreen(this));
		screenMap.put(ScreenOptions.ENDGAME.getOption(), new EndScreen(this));
	}
}