package OkayOthello.players;

import OkayOthello.core.Field;
import OkayOthello.core.Point;
import OkayOthello.io.GameIoHelper;

import java.util.List;

public class HumanPlayer implements Player {
    @Override
    public Point chooseMove(Field field, List<Point> availableMoves) {
        return GameIoHelper.getMoveFromPlayer(field, availableMoves);
    }
}
