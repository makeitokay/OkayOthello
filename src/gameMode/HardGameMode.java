package gameMode;

import players.EasyComputerPlayer;
import players.HardComputerPlayer;
import players.HumanPlayer;
import players.Player;

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
