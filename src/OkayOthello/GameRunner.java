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
                System.out.println("Ходят ЧЁРНЫЕ");
                var blackPlayerMove = blackPlayer.chooseMove(game.getFieldCopy(), game.getAvailableMoves(), ChipType.Black);
                System.out.printf("ЧЁРНЫЕ выбрали точку %s%n%n", blackPlayerMove);
                game.move(blackPlayerMove);
            }
            if (game.canWhitePlayerMove()) {
                System.out.println("Ходят БЕЛЫЕ");
                var whitePlayerMove = whitePlayer.chooseMove(game.getFieldCopy(), game.getAvailableMoves(), ChipType.White);
                System.out.printf("БЕЛЫЕ выбрали точку %s%n%n", whitePlayerMove);
                game.move(whitePlayerMove);
            }
        }
        var result = game.getGameResult();
        var winner = result.blackPlayerScore() > result.whitePlayerScore() ? "ЧЕРНЫЕ" : "БЕЛЫЕ";
        // todo: to gameiohelper
        System.out.printf("ИГРА ЗАВЕРШЕНА!%nРЕЗУЛЬТАТЫ:%nБЕЛЫЕ набрали %s очков%nЧЕРНЫЕ набрали %s очков%nПОБЕДИЛИ %s%n%n",
                result.whitePlayerScore(), result.blackPlayerScore(), winner);

    }
}
