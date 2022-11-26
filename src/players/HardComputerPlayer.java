package players;

import core.Field;
import core.Point;

import java.util.List;

public class HardComputerPlayer implements Player {
    @Override
    public Point chooseMove(Field field, List<Point> availableMoves) {
        return availableMoves.get(0);
    }
}
