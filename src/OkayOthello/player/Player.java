package OkayOthello.player;

import OkayOthello.core.ChipType;
import OkayOthello.core.Field;
import OkayOthello.core.Point;

import java.util.List;

public interface Player {
    ChosenMove chooseMove(Field field, List<Point> availableMoves, ChipType playerChip);
}
