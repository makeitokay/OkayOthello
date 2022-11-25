package players;

import core.ChipType;
import core.Point;

import java.util.List;

public interface Player {
    Point chooseMove(ChipType[][] field, List<Point> availableMoves);
}
