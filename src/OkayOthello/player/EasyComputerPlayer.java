package OkayOthello.player;

import OkayOthello.core.ChipType;
import OkayOthello.core.Field;
import OkayOthello.core.Point;

import java.util.List;

public class EasyComputerPlayer implements Player {
    @Override
    public Point chooseMove(Field field, List<Point> availableMoves, ChipType playerChip) {
        var maxMoveWeight = -129.0;
        var maxMoveWeightIndex = -1;
        for (int i = 0; i < availableMoves.size(); ++i) {
            var move = availableMoves.get(i);
            var moveWeight = MoveCalculator.getMoveWeight(field, move, playerChip);
            if (moveWeight > maxMoveWeight) {
                maxMoveWeight = moveWeight;
                maxMoveWeightIndex = i;
            }
        }

        return availableMoves.get(maxMoveWeightIndex);
    }
}
