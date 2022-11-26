package OkayOthello.players;

import OkayOthello.core.Field;
import OkayOthello.core.Point;
import OkayOthello.io.GameIoHelper;

import java.util.List;

public class EasyComputerPlayer implements Player {
    @Override
    public Point chooseMove(Field field, List<Point> availableMoves) {
        GameIoHelper.printFieldWithAvailableMoves(field, availableMoves);
        return availableMoves.get(0);
    }
}
