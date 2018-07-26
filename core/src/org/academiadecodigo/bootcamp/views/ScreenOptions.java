package org.academiadecodigo.bootcamp.views;

public enum ScreenOptions {

    MENU(0),
    PREFERENCES(1),
    APPLICATION(2),
    ENDGAME(3);

    private int option;

    ScreenOptions(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }
}
