package OkayOthello.gameMode;

import OkayOthello.players.HardComputerPlayer;
import OkayOthello.players.HumanPlayer;
import OkayOthello.players.Player;

public class MultiplayerGameMode implements GameMode {
    private final Player blackPlayer;
    private final Player whitePlayer;

    public MultiplayerGameMode() {
        blackPlayer = new HumanPlayer();
        whitePlayer = new HumanPlayer();
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
