package providers;

import core.ChipType;
import core.Point;
import io.GameIoHelper;

import java.util.List;

public class MultiplayerGameMoveProvider implements MoveProvider {
    @Override
    public Point provideBlackPlayerMove(ChipType[][] field, List<Point> availableMoves) {
        System.out.println("Ходит игрок №1");
        return GameIoHelper.getMoveFromPlayer(field, availableMoves);
    }

    @Override
    public Point provideWhitePlayerMove(ChipType[][] field, List<Point> availableMoves) {
        System.out.println("Ходит игрок №2");
        return GameIoHelper.getMoveFromPlayer(field, availableMoves);
    }
}
