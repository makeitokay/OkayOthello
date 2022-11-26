package OkayOthello.players;

import OkayOthello.core.Field;
import OkayOthello.core.Point;

import java.util.List;

public interface Player {
    Point chooseMove(Field field, List<Point> availableMoves);
}