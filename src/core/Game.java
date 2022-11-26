package core;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Field field;
    private ChipType currentChip;

    public Game() {
        field = new Field(Constants.FIELD_SIZE);

        field.setChipAt(new Point(3, 3), ChipType.White);
        field.setChipAt(new Point(3, 4), ChipType.Black);
        field.setChipAt(new Point(4, 3), ChipType.Black);
        field.setChipAt(new Point(4, 4), ChipType.White);

        currentChip = ChipType.Black;
    }

    public void move(Point point) {
        field.setChipAt(point, currentChip);

        var closures = field.getClosures(point, currentChip);
        for (var closure : closures) {
            field.closeClosure(closure);
        }

        currentChip = Utils.swapChip(currentChip);
        if (!canPlayerMove(currentChip)) {
            currentChip = Utils.swapChip(currentChip);
        }
    }

    public boolean canWhitePlayerMove() {
        return canPlayerMove(ChipType.White);
    }

    public boolean canBlackPlayerMove() {
        return canPlayerMove(ChipType.Black);
    }

    private boolean canPlayerMove(ChipType chip) {
        return getAvailableMoves(chip).size() > 0;
    }

    public boolean isCompleted() {
        int emptyCells = 0;
        int whiteCells = 0;
        int blackCells = 0;
        for (int i = 0; i < Constants.FIELD_SIZE; ++i) {
            for (int j = 0; j < Constants.FIELD_SIZE; ++j) {
                var cell = field.getChipAt(new Point(i, j));
                if (cell == null) {
                    ++emptyCells;
                    continue;
                }
                switch (cell) {
                    case Black -> ++blackCells;
                    case White -> ++whiteCells;
                }
            }
        }
        return (emptyCells == 0) || (whiteCells == 0) || (blackCells == 0)
                || (!canBlackPlayerMove() && !canWhitePlayerMove());
    }

    public List<Point> getAvailableMoves() {
        return getAvailableMoves(currentChip);
    }

    private List<Point> getAvailableMoves(ChipType chip) {
        var moves = new ArrayList<Point>();
        for (int i = 0; i < Constants.FIELD_SIZE; ++i) {
            for (int j = 0; j < Constants.FIELD_SIZE; ++j) {
                var point = new Point(i, j);
                var cell = field.getChipAt(point);
                if (cell != null) {
                    continue;
                }
                if (field.hasAnyClosure(point, chip)) {
                    moves.add(point);
                }
            }
        }

        return moves;
    }

    public Field getFieldCopy() {
        return field.getCopy();
    }
}
