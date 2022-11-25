package providers;

import core.ChipType;
import core.Point;
import io.GameIoHelper;

import java.util.List;

public class EasyGameMoveProvider implements MoveProvider {
    @Override
    public Point provideBlackPlayerMove(ChipType[][] field, List<Point> availableMoves) {
        System.out.println("Ходит игрок");
        return GameIoHelper.getMoveFromPlayer(field, availableMoves);
    }

    @Override
    public Point provideWhitePlayerMove(ChipType[][] field, List<Point> availableMoves) {
        System.out.println("Ходит тупой кампухтер");
        // тут логика компухтера как ходить
        var point = availableMoves.get(0);
        System.out.printf("Тупой кампухтер выбрал точку %s%n", point);
        return availableMoves.get(0);
    }
}
