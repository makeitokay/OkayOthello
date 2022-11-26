package OkayOthello.gameMode;

import OkayOthello.players.EasyComputerPlayer;
import OkayOthello.players.HardComputerPlayer;
import OkayOthello.players.HumanPlayer;
import OkayOthello.players.Player;

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
