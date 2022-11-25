import core.Game;
import gameMode.EasyGameMode;
import gameMode.GameMode;
import gameMode.HardGameMode;
import gameMode.MultiplayerGameMode;

public class GameRunner {
    public static void RunEasyGame() {
        Run(new Game(), new EasyGameMode());
    }

    public static void RunHardGame() {
        Run(new Game(), new HardGameMode());
    }

    public static void RunMultiplayerGame() {
        Run(new Game(), new MultiplayerGameMode());
    }

    private static void Run(Game game, GameMode mode) {
        var blackPlayer = mode.getBlackPlayer();
        var whitePlayer = mode.getWhitePlayer();

        while (!game.isCompleted()) {
            if (game.canBlackPlayerMove()) {
                var blackPlayerMove = blackPlayer.chooseMove(game.getField(), game.getAvailableMoves());
                game.move(blackPlayerMove);
            }
            if (game.canWhitePlayerMove()) {
                var whitePlayerMove = whitePlayer.chooseMove(game.getField(), game.getAvailableMoves());
                game.move(whitePlayerMove);
            }
        }
    }
}
