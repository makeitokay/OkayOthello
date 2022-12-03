package OkayOthello.player;

import OkayOthello.core.ChipType;
import OkayOthello.core.Field;
import OkayOthello.core.Point;
import OkayOthello.io.GameIoHelper;

import java.util.List;

public class HumanPlayer implements Player {
    @Override
    public ChosenMove chooseMove(Field field, List<Point> availableMoves, ChipType playerChip) {
        return GameIoHelper.getMoveFromPlayer(field, availableMoves);
    }
}
