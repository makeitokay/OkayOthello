public class Game {
    private final Field field;
    private final GameMode mode;

    public Game(GameMode mode) {
        this.mode = mode;
        field = new Field(Constants.FIELD_SIZE);
    }

    public Field getField() {
        return field;
    }

    public static Game createEasyGame() {
        return new Game(GameMode.Easy);
    }

    public static Game createHardGame() {
        return new Game(GameMode.Hard);
    }

    public static Game createMultiplayerGame() {
        return new Game(GameMode.Multiplayer);
    }
}
