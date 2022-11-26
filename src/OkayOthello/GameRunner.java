package OkayOthello;

import OkayOthello.core.ChipType;
import OkayOthello.core.Game;
import OkayOthello.gameMode.EasyGameMode;
import OkayOthello.gameMode.GameMode;
import OkayOthello.gameMode.HardGameMode;
import OkayOthello.gameMode.MultiplayerGameMode;

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
                var blackPlayerMove = blackPlayer.chooseMove(game.getFieldCopy(), game.getAvailableMoves(), ChipType.Black);
                game.move(blackPlayerMove);
            }
            if (game.canWhitePlayerMove()) {
                var whitePlayerMove = whitePlayer.chooseMove(game.getFieldCopy(), game.getAvailableMoves(), ChipType.White);
                game.move(whitePlayerMove);
            }
        }
    }
}
