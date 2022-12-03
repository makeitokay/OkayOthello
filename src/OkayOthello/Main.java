package OkayOthello;

import OkayOthello.io.MainMenuIoHelper;

public class Main {
    public static void main(String[] args) {
        MainMenuIoHelper.printMainMenu();
        while (true) {
            var command = MainMenuIoHelper.getMainMenuCommand();
            System.out.printf("Вы выбрали %s%n", command.toString());
            switch (command) {
                case PlayEasyMode -> GameRunner.runEasyGame();
                case PlayHardMode -> GameRunner.runHardGame();
                case PlayMultiplayer -> GameRunner.runMultiplayerGame();
                case PrintBestResult -> {

                }
                case Help -> MainMenuIoHelper.printMainMenu();
                case Quit -> {
                    System.out.println("Досвидули!");
                    return;
                }
            }
        }

    }
}