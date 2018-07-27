package org.academiadecodigo.bootcamp.views;

public enum ScreenOptions {

    MENU(0),
    APPLICATION(1),
    ENDGAME(2);

    private int option;

    ScreenOptions(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }
}
