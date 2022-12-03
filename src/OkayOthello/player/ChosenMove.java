package OkayOthello.player;

import OkayOthello.core.Point;
import org.jetbrains.annotations.Nullable;

// example of bad architecture ¯\_(ツ)_/¯
public class ChosenMove {
    private final MoveType type;
    @Nullable
    private final Point move;

    private ChosenMove(MoveType type, @Nullable Point move) {
        this.type = type;
        this.move = move;
    }

    public static ChosenMove moveNext(Point move) {
        return new ChosenMove(MoveType.MoveNext, move);
    }

    public static ChosenMove moveBack() {
        return new ChosenMove(MoveType.MoveBack, null);
    }

    public MoveType getType() {
        return type;
    }

    public @Nullable Point getMove() {
        return move;
    }
}
