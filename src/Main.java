import io.MainMenuIoHelper;

public class Main {
    public static void main(String[] args) {
        MainMenuIoHelper.printMainMenu();
        while (true) {
            var command = MainMenuIoHelper.getMainMenuCommand();
            System.out.printf("Вы выбрали %s%n", command.toString());
            switch (command) {
                case PlayEasyMode -> {
                    var game = Game.createEasyGame();
                }
                case PlayHardMode -> {
                    var game = Game.createHardGame();
                }
                case PlayMultiplayer -> {
                    var game = Game.createMultiplayerGame();
                }
                case PrintBestResult -> {

                }
                case Quit -> {
                    System.out.println("Досвидули!");
                    return;
                }
            }
        }

    }
}