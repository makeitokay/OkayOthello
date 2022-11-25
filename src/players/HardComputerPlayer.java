package players;

import core.ChipType;
import core.Point;

import java.util.List;

public class HardComputerPlayer implements Player {
    @Override
    public Point chooseMove(ChipType[][] field, List<Point> availableMoves) {
        return availableMoves.get(0);
    }
}
