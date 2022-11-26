package players;

import core.Field;
import core.Point;
import io.GameIoHelper;

import java.util.List;

public class EasyComputerPlayer implements Player {
    @Override
    public Point chooseMove(Field field, List<Point> availableMoves) {
        GameIoHelper.printFieldWithAvailableMoves(field, availableMoves);
        return availableMoves.get(0);
    }
}
