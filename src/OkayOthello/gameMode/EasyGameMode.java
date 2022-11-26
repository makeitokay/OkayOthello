package OkayOthello.gameMode;

import OkayOthello.player.EasyComputerPlayer;
import OkayOthello.player.HumanPlayer;
import OkayOthello.player.Player;

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
