public class Game {
    private final Field field;

    public Game() {
        field = new Field(Constants.FIELD_SIZE);

        field.setChip(3, 3, ChipType.White);
        field.setChip(3, 4, ChipType.Black);
        field.setChip(4, 3, ChipType.Black);
        field.setChip(4, 4, ChipType.White);
    }

    public Field getField() {
        return field;
    }
}
