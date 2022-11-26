package OkayOthello.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Field {
    private final ChipType[][] field;

    public Field(int size) {
        field = new ChipType[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                field[i][j] = null;
            }
        }
    }

    private Field(ChipType[][] field) {
        this.field = field;
    }

    public int getSize() {
        return field.length;
    }

    public ChipType getChipAt(Point point) {
        return field[point.x()][point.y()];
    }

    public void setChipAt(Point point, ChipType chip) {
        field[point.x()][point.y()] = chip;
    }

    public boolean hasAnyClosure(Point point, ChipType chip) {
        return getClosures(point, chip).size() > 0;
    }

    public List<Closure> getClosures(Point point, ChipType chip) {
        var closures = new ArrayList<Closure>();
        for (var direction : PointDirection.POINT_DIRECTIONS) {
            int x = point.x() + direction.getDx(), y = point.y() + direction.getDy();
            int opponentChipsCount = 0;
            int totalChipsCount = 0;
            var opponent = Utils.swapChip(chip);
            while (x > 0 && x < getSize() && y > 0 && y < getSize()) {
                if (field[x][y] == chip) {
                    if (totalChipsCount == opponentChipsCount && totalChipsCount != 0) {
                        closures.add(new Closure(point, direction, totalChipsCount));
                    }
                    break;
                } else if (field[x][y] == opponent) {
                    ++opponentChipsCount;
                }
                ++totalChipsCount;
                x += direction.getDx();
                y += direction.getDy();
            }
        }

        return closures;
    }

    public void closeClosure(Closure closure) {
        var size = closure.size();
        var direction = closure.direction();
        var startPoint = closure.startPoint();
        var startPointX = startPoint.x();
        var startPointY = startPoint.y();

        for (int i = 1; i <= size; ++i) {
            field[startPointX + i * direction.getDx()][startPointY + i * direction.getDy()] = field[startPointX][startPointY];
        }
    }

    public Field getCopy() {
        return new Field(
                Arrays.stream(field)
                        .map(ChipType[]::clone)
                        .toArray(ChipType[][]::new)
        );
    }
}
