public class Game {
    private final Field field;

    public Game() {
        field = new Field(Constants.FIELD_SIZE);
    }

    public Field getField() {
        return field;
    }
}
