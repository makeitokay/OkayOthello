package players;

import core.ChipType;
import core.Point;
import io.GameIoHelper;

import java.util.List;

public class HumanPlayer implements Player {
    @Override
    public Point chooseMove(ChipType[][] field, List<Point> availableMoves) {
        return GameIoHelper.getMoveFromPlayer(field, availableMoves);
    }
}
