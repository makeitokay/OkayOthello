package OkayOthello.io;

public class MainMenuIoHelper {
    public static void printMainMenu() {
        System.out.println(
                """
                === ИГРА РЕВЕРСИ ===
                1. Играть против компьютера (уровень новичка)
                2. Играть против компьютера (уровень профессионала)
                3. Играть против другого человека (на одном компьютере)
                4. Показать лучший результат в текущей сессии
                5. Вывести список команд
                6. Выйти из игры
                """);
    }

    public static MainMenuCommand getMainMenuCommand() {
        System.out.print("Введите НОМЕР нужного пункта меню: ");
        var commandIndex = IoHelper.GetNumberFromInput(1, 6) - 1;
        return MainMenuCommand.values()[commandIndex];
    }
}
