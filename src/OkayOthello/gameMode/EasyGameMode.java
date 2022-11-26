package OkayOthello.gameMode;

import OkayOthello.players.EasyComputerPlayer;
import OkayOthello.players.HumanPlayer;
import OkayOthello.players.Player;

public class EasyGameMode implements GameMode {
    private final Player blackPlayer;
    private final Player whitePlayer;

    public EasyGameMode() {
        blackPlayer = new HumanPlayer();
        whitePlayer = new EasyComputerPlayer();
    }

    @Override
    public Player getBlackPlayer() {
        return blackPlayer;
    }

    @Override
    public Player getWhitePlayer() {
        return whitePlayer;
    }
}
