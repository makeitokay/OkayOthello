package OkayOthello.players;

import OkayOthello.core.Field;
import OkayOthello.core.Point;

import java.util.List;

public class HardComputerPlayer implements Player {
    @Override
    public Point chooseMove(Field field, List<Point> availableMoves) {
        return availableMoves.get(0);
    }
}
