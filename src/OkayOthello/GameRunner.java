package OkayOthello;

import OkayOthello.core.ChipType;
import OkayOthello.core.Game;
import OkayOthello.gameMode.EasyGameMode;
import OkayOthello.gameMode.GameMode;
import OkayOthello.gameMode.HardGameMode;
import OkayOthello.gameMode.MultiplayerGameMode;
import OkayOthello.io.GameIoHelper;
import OkayOthello.player.MoveType;
import OkayOthello.player.Player;

public class GameRunner {
    public static void runEasyGame() {
        run(new Game(), new EasyGameMode());
    }

    public static void runHardGame() {
        run(new Game(), new HardGameMode());
    }

    public static void runMultiplayerGame() {
        run(new Game(), new MultiplayerGameMode());
    }

    private static void run(Game game, GameMode mode) {
        var blackPlayer = mode.getBlackPlayer();
        var whitePlayer = mode.getWhitePlayer();

        while (!game.isCompleted()) {
            if (game.canBlackPlayerMove()) {
                processMove(game, blackPlayer, ChipType.Black);
            }
            if (game.canWhitePlayerMove()) {
                processMove(game, whitePlayer, ChipType.White);
            }
        }
        GameIoHelper.printGameResult(game.getGameResult());
    }

    private static void processMove(Game game, Player player, ChipType playerChip) {
        var stringPlayer = playerChip == ChipType.White ? "БЕЛЫЕ" : "ЧЁРНЫЕ";
        System.out.printf("Ходят %s%n", stringPlayer);
        while (true) {
            var playerMove = player.chooseMove(game.getFieldCopy(), game.getAvailableMoves(), playerChip);
            if (playerMove.getType() == MoveType.MoveBack) {
                if (!game.canCancelMove()) {
                    System.out.println("Дружочек-пирожочек, отменить ход ты не имеешь возможности, извиняй.");
                    continue;
                }
                game.cancelMove();
                System.out.printf("%s ОТМЕНИЛИ СВОЙ ПРЕДЫДУЩИЙ ХОД%n", stringPlayer);
            } else {
                var movePoint = playerMove.getMove();
                System.out.printf("%s выбрали точку %s%n%n", stringPlayer, movePoint);
                game.move(movePoint);
                break;
            }
        }
    }
}
