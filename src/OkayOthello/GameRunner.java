package OkayOthello;

import OkayOthello.core.ChipType;
import OkayOthello.core.Game;
import OkayOthello.core.GameResult;
import OkayOthello.gameMode.EasyGameMode;
import OkayOthello.gameMode.GameMode;
import OkayOthello.gameMode.HardGameMode;
import OkayOthello.gameMode.MultiplayerGameMode;
import OkayOthello.io.GameIoHelper;
import OkayOthello.player.MoveType;
import OkayOthello.player.Player;
import OkayOthello.repository.GameResultRepository;

public class GameRunner {
    private final GameResultRepository gameResultRepository;

    public GameRunner() {
        gameResultRepository = new GameResultRepository();
    }

    public void runEasyGame() {
        run(new Game(), new EasyGameMode());
    }

    public void runHardGame() {
        run(new Game(), new HardGameMode());
    }

    public void runMultiplayerGame() {
        run(new Game(), new MultiplayerGameMode());
    }

    private void run(Game game, GameMode mode) {
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
        var result = game.getGameResult();
        gameResultRepository.add(result);
        GameIoHelper.printGameResult(result);
    }

    private void processMove(Game game, Player player, ChipType playerChip) {
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

    public void printBestGameResults() {
        var blackPlayerBestResult = gameResultRepository.getBestBlackPlayerResult();
        var whitePlayerBestResult = gameResultRepository.getBestWhitePlayerResult();
        if (blackPlayerBestResult == null || whitePlayerBestResult == null) {
            System.out.println("Сначала поиграй, потом результаты проси!");
            return;
        }
        GameIoHelper.printBestPlayerScore(blackPlayerBestResult.blackPlayerScore(), ChipType.Black);
        GameIoHelper.printBestPlayerScore(whitePlayerBestResult.whitePlayerScore(), ChipType.White);
    }
}
