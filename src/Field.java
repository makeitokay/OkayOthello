public class Field {
    private final Cell[][] field;
    private final int size;

    public Field(int size) {
        this.size = size;
        field = new Cell[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                field[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return field[x][y];
    }

    public void swapChip(int x, int y) {
        field[x][y].swapChip();
    }

    public void setChip(int x, int y, ChipType chip) {
        field[x][y].setChip(chip);
    }

    public int getSize() {
        return size;
    }
}
