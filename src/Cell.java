public class Cell {
    private final int x;
    private final int y;
    private ChipType Chip;
    private final boolean isEmpty;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ChipType getChip() {
        return Chip;
    }

    public void setChip(ChipType chip) {
        Chip = chip;
    }

    public void swapChip() {
        if (Chip == ChipType.Black) {
            Chip = ChipType.White;
        }
        else if (Chip == ChipType.White) {
            Chip = ChipType.Black;
        }
    }
}
