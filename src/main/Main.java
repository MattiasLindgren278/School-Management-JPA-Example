package main;

import ui.MainMenus;
import utilities.InputAssistance;

public class Main {

    static MainMenus startProgram = new MainMenus();
    static InputAssistance ia = new InputAssistance();

    public static void main(String[] args) {

        ia.getEmf();
        startProgram.mainMenu();
        ia.getEmf().close();
        ia.getScanner().close();
    }

}
