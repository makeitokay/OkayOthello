package OkayOthello.player;

import OkayOthello.core.ChipType;
import OkayOthello.core.Field;
import OkayOthello.core.Point;
import OkayOthello.core.Utils;

public class MoveCalculator {
    public static double getMoveWeight(Field field, Point move, ChipType playerChip) {
        var moveWeight = 0d;
        var closures = field.getClosures(move, playerChip);
        for (var closure : closures) {
            var direction = closure.direction();
            var startPoint = closure.startPoint();

            for (int j = 1; j <= closure.size(); ++j) {
                var point = new Point(startPoint.x() + j * direction.getDx(), startPoint.y() + j * direction.getDy());
                if (Utils.isEdgePoint(field, point)) {
                    moveWeight += 2;
                } else {
                    moveWeight += 1;
                }
            }
        }
        if (Utils.isCornerPoint(field, move)) {
            moveWeight += 0.8;
        } else if (Utils.isEdgePoint(field, move)) {
            moveWeight += 0.4;
        }

        return moveWeight;
    }
}
