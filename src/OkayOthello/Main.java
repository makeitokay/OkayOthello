package OkayOthello;

import OkayOthello.io.MainMenuIoHelper;

public class Main {
    public static void main(String[] args) {
        MainMenuIoHelper.printMainMenu();
        var runner = new GameRunner();
        while (true) {
            var command = MainMenuIoHelper.getMainMenuCommand();
            System.out.printf("Вы выбрали %s%n", command.toString());
            switch (command) {
                case PlayEasyMode -> runner.runEasyGame();
                case PlayHardMode -> runner.runHardGame();
                case PlayMultiplayer -> runner.runMultiplayerGame();
                case PrintBestResult -> runner.printBestGameResults();
                case Help -> MainMenuIoHelper.printMainMenu();
                case Quit -> {
                    System.out.println("Досвидули!");
                    return;
                }
            }
        }

    }
}