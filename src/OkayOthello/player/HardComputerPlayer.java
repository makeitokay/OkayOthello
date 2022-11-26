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
            var move = availableMoves.get(i);
            var computerMoveWeight = MoveCalculator.getMoveWeight(field, move, playerChip);
            for (var closure : field.getClosures(move, playerChip)) {
                field.closeClosure(closure);
            }
            var maxHumanMoveWeight = 0d;
            for (int x = 0; x < field.getSize(); ++x) {
                for (int y = 0; y < field.getSize(); ++y) {
                    var humanMove = new Point(x, y);
                    var humanMoveWeight = MoveCalculator.getMoveWeight(field, humanMove, Utils.swapChip(playerChip));
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
