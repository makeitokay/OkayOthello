package providers;

import core.ChipType;
import core.Point;

import java.util.List;

public interface MoveProvider {
    Point provideBlackPlayerMove(ChipType[][] field, List<Point> availableMoves);
    Point provideWhitePlayerMove(ChipType[][] field, List<Point> availableMoves);
}
