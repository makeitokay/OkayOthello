package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private final ChipType[][] field;
    private ChipType currentPlayer;

    public Game() {
        var size = Constants.FIELD_SIZE;
        field = new ChipType[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                field[i][j] = null;
            }
        }

        field[3][3] = ChipType.White;
        field[3][4] = ChipType.Black;
        field[4][3] = ChipType.Black;
        field[4][4] = ChipType.White;

        currentPlayer = ChipType.Black;

        getClosures(new Point(2, 3), ChipType.Black);
    }

    public void move(Point point) {
        field[point.x()][point.y()] = currentPlayer;

        var closures = getClosures(point, currentPlayer);
        for (var closure : closures) {
            closeClosure(closure);
        }

        currentPlayer = Utils.swapPlayers(currentPlayer);
        if (!canPlayerMove(currentPlayer)) {
            currentPlayer = Utils.swapPlayers(currentPlayer);
        }
    }

    public boolean canWhitePlayerMove() {
        return canPlayerMove(ChipType.White);
    }

    public boolean canBlackPlayerMove() {
        return canPlayerMove(ChipType.Black);
    }

    private boolean canPlayerMove(ChipType player) {
        return getAvailableMoves(player).size() > 0;
    }

    public boolean isCompleted() {
        int emptyCells = 0;
        int whiteCells = 0;
        int blackCells = 0;
        for (int i = 0; i < field.length; ++i) {
            for (int j = 0; j < field[0].length; ++j) {
                var cell = field[i][j];
                if (cell == null) {
                    ++emptyCells;
                    continue;
                }
                switch (field[i][j]) {
                    case Black -> ++blackCells;
                    case White -> ++whiteCells;
                }
            }
        }
        return (emptyCells == 0) || (whiteCells == 0) || (blackCells == 0)
                || (!canBlackPlayerMove() && !canWhitePlayerMove());
    }

    public List<Point> getAvailableMoves() {
        return getAvailableMoves(currentPlayer);
    }

    private List<Point> getAvailableMoves(ChipType player) {
        var moves = new ArrayList<Point>();
        for (int i = 0; i < Constants.FIELD_SIZE; ++i) {
            for (int j = 0; j < Constants.FIELD_SIZE; ++j) {
                if (field[i][j] != null) {
                    continue;
                }
                var point = new Point(i, j);
                if (hasAnyClosure(point, player)) {
                    moves.add(point);
                }
            }
        }

        return moves;
    }

    private boolean hasAnyClosure(Point point, ChipType player) {
        return getClosures(point, player).size() > 0;
    }

    private List<Closure> getClosures(Point point, ChipType player) {
        var closures = new ArrayList<Closure>();
        for (var direction : PointDirection.POINT_DIRECTIONS) {
            int x = point.x() + direction.getDx(), y = point.y() + direction.getDy();
            int opponentChipsCount = 0;
            int totalChipsCount = 0;
            var opponent = Utils.swapPlayers(player);
            while (x > 0 && x < Constants.FIELD_SIZE && y > 0 && y < Constants.FIELD_SIZE) {
                if (field[x][y] == player) {
                    if (totalChipsCount == opponentChipsCount && totalChipsCount != 0) {
                        closures.add(new Closure(point, direction, totalChipsCount));
                    }
                    break;
                }
                else if (field[x][y] == opponent) {
                    ++opponentChipsCount;
                }
                ++totalChipsCount;
                x += direction.getDx();
                y += direction.getDy();
            }
        }

        return closures;
    }

    private void closeClosure(Closure closure) {
        var size = closure.getSize();
        var direction = closure.getDirection();
        var startPoint = closure.getStartPoint();
        var startPointX = startPoint.x();
        var startPointY = startPoint.y();

        for (int i = 1; i <= size; ++i) {
            field[startPointX + i * direction.getDx()][startPointY + i * direction.getDy()] = currentPlayer;
        }
    }

    public ChipType[][] getField() {
        return Arrays.stream(field)
                .map(ChipType[]::clone)
                .toArray(ChipType[][]::new);
    }
}
