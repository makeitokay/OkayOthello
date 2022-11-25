import core.Game;
import core.GameMode;
import io.GameIoHelper;
import providers.EasyGameMoveProvider;
import providers.HardGameMoveProvider;
import providers.MultiplayerGameMoveProvider;

public class GameRunner {
    public static void RunEasyGame() {
        Run(new Game(GameMode.Easy));
    }

    public static void RunHardGame() {
        Run(new Game(GameMode.Hard));
    }

    public static void RunMultiplayerGame() {
        Run(new Game(GameMode.Multiplayer));
    }

    private static void Run(Game game) {
        // todo: we dont need mode in game class
        var moveProvider = switch (game.getMode()) {
            case Easy -> new EasyGameMoveProvider();
            case Hard -> new HardGameMoveProvider();
            case Multiplayer -> new MultiplayerGameMoveProvider();
        };
        while (!game.isCompleted()) {
            if (game.canBlackPlayerMove()) {
                var blackPlayerMove = moveProvider.provideBlackPlayerMove(game.getField(), game.getAvailableMoves());
                game.move(blackPlayerMove);
            }
            if (game.canWhitePlayerMove()) {
                var moves = game.getAvailableMoves();
                GameIoHelper.printFieldWithAvailableMoves(game.getField(), moves);
                var whitePlayerMove = moveProvider.provideWhitePlayerMove(game.getField(), moves);
                game.move(whitePlayerMove);
            }
        }
    }
}
