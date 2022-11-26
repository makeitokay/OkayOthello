package players;

import core.ChipType;
import core.Field;
import core.Point;
import io.GameIoHelper;

import java.util.List;

public class HumanPlayer implements Player {
    @Override
    public Point chooseMove(Field field, List<Point> availableMoves) {
        return GameIoHelper.getMoveFromPlayer(field, availableMoves);
    }
}
