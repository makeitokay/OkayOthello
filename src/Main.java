import io.MainMenuIoHelper;

public class Main {
    public static void main(String[] args) {
        MainMenuIoHelper.printMainMenu();
        while (true) {
            var command = MainMenuIoHelper.getMainMenuCommand();
            System.out.printf("Вы выбрали %s%n", command.toString());
            switch (command) {
                case PlayEasyMode -> GameRunner.RunEasyGame();
                case PlayHardMode -> GameRunner.RunHardGame();
                case PlayMultiplayer -> GameRunner.RunMultiplayerGame();
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