package OkayOthello.gameMode;

import OkayOthello.player.HardComputerPlayer;
import OkayOthello.player.HumanPlayer;
import OkayOthello.player.Player;

public class HardGameMode implements GameMode {
    private final Player blackPlayer;
    private final Player whitePlayer;

    public HardGameMode() {
        blackPlayer = new HumanPlayer();
        whitePlayer = new HardComputerPlayer();
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
