package OkayOthello.repository;

import OkayOthello.core.GameResult;

import java.util.Comparator;

public class GameResultRepository extends Repository<GameResult> {
    public GameResult getBestBlackPlayerResult() {
        return items.stream().max(Comparator.comparingInt(GameResult::blackPlayerScore)).orElse(null);
    }

    public GameResult getBestWhitePlayerResult() {
        return items.stream().max(Comparator.comparingInt(GameResult::whitePlayerScore)).orElse(null);
    }
}
