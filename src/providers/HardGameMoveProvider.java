package providers;

import core.ChipType;
import core.Point;
import io.GameIoHelper;

import java.util.List;

public class HardGameMoveProvider implements MoveProvider {
    @Override
    public Point provideBlackPlayerMove(ChipType[][] field, List<Point> availableMoves) {
        System.out.println("Ходит игрок");
        return GameIoHelper.getMoveFromPlayer(field, availableMoves);
    }

    @Override
    public Point provideWhitePlayerMove(ChipType[][] field, List<Point> availableMoves) {
        System.out.println("Ходит умный кампухтер");
        // тут логика компухтера как ходить
        return availableMoves.get(0);
    }
}
