package OkayOthello.player;

import OkayOthello.core.ChipType;
import OkayOthello.core.Field;
import OkayOthello.core.Point;
import OkayOthello.core.Utils;
import OkayOthello.io.GameIoHelper;

import java.util.List;

public class HardComputerPlayer implements Player {
    @Override
    public Point chooseMove(Field field, List<Point> availableMoves, ChipType playerChip) {
        var maxMoveWeight = -129.0;
        var maxMoveWeightIndex = -1;
        for (int i = 0; i < availableMoves.size(); ++i) {
            var fieldCopy = field.getCopy();
            var move = availableMoves.get(i);
            var computerMoveWeight = MoveCalculator.getMoveWeight(fieldCopy, move, playerChip);
            for (var closure : fieldCopy.getClosures(move, playerChip)) {
                fieldCopy.closeClosure(closure);
            }
            var maxHumanMoveWeight = 0d;
            for (int x = 0; x < fieldCopy.getSize(); ++x) {
                for (int y = 0; y < fieldCopy.getSize(); ++y) {
                    var humanMove = new Point(x, y);
                    var humanMoveWeight = MoveCalculator.getMoveWeight(fieldCopy, humanMove, Utils.swapChip(playerChip));
                    if (humanMoveWeight > maxHumanMoveWeight) {
                        maxHumanMoveWeight = humanMoveWeight;
                    }
                }
            }
            computerMoveWeight -= maxHumanMoveWeight;

            if (computerMoveWeight > maxMoveWeight) {
                maxMoveWeight = computerMoveWeight;
                maxMoveWeightIndex = i;
            }
        }

        return availableMoves.get(maxMoveWeightIndex);
    }
}
