package players;

import core.Field;
import core.Point;

import java.util.List;

public interface Player {
    Point chooseMove(Field field, List<Point> availableMoves);
}
