package OkayOthello.core;

import OkayOthello.repository.FieldSnapshotRepository;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Field field;
    private ChipType currentChip;
    private final FieldSnapshotRepository fieldSnapshotRepository;

    public Game() {
        field = new Field(Constants.FIELD_SIZE);

        field.setChipAt(new Point(3, 3), ChipType.White);
        field.setChipAt(new Point(3, 4), ChipType.Black);
        field.setChipAt(new Point(4, 3), ChipType.Black);
        field.setChipAt(new Point(4, 4), ChipType.White);

        currentChip = ChipType.Black;

        fieldSnapshotRepository = new FieldSnapshotRepository();
    }

    public void move(Point point) {
        if (!canPlayerMove(currentChip)) {
            throw new IllegalStateException("Current player can't move");
        }

        fieldSnapshotRepository.add(new FieldSnapshot(getFieldCopy(), currentChip));

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
        int emptyCells = countChips(null);
        int whiteCells = countChips(ChipType.White);
        int blackCells = countChips(ChipType.Black);
        return (emptyCells == 0) || (whiteCells == 0) || (blackCells == 0)
                || (!canBlackPlayerMove() && !canWhitePlayerMove());
    }

    private int countChips(ChipType chip) {
        int chips = 0;
        for (int i = 0; i < field.getSize(); ++i) {
            for (int j = 0; j < field.getSize(); ++j) {
                if (chip == field.getChipAt(new Point(i, j))) {
                    ++chips;
                }
            }
        }
        return chips;
    }

    public GameResult getGameResult() {
        return new GameResult(countChips(ChipType.White), countChips(ChipType.Black));
    }

    public List<Point> getAvailableMoves() {
        return getAvailableMoves(currentChip);
    }

    private List<Point> getAvailableMoves(ChipType chip) {
        var moves = new ArrayList<Point>();
        for (int i = 0; i < field.getSize(); ++i) {
            for (int j = 0; j < field.getSize(); ++j) {
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

    public boolean canCancelMove() {
        return fieldSnapshotRepository.anyPlayerSnapshot(currentChip);
    }

    public void cancelMove() {
        if (!canCancelMove()) {
            throw new IllegalStateException();
        }
        field = fieldSnapshotRepository.popUntilPlayerLastMove(currentChip).field();
    }
}
