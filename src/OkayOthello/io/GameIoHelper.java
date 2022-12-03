package OkayOthello.io;

import OkayOthello.core.*;
import OkayOthello.player.ChosenMove;
import OkayOthello.repository.GameResultRepository;

import java.util.List;

public class GameIoHelper {
    private static final List<String> COLUMNS = List.of("A", "B", "C", "D", "E", "F", "G", "H");

    public static ChosenMove getMoveFromPlayer(Field field, List<Point> availableMoves) {
        printFieldWithAvailableMoves(field, availableMoves);
        System.out.println("Выберите номер ячейки, в которую хотите сходить (0, чтобы отменить СВОЙ ПРЕДЫДУЩИЙ ход)");
        var cellNumber = IoHelper.getNumberFromInput(0, availableMoves.size());
        if (cellNumber == 0) {
            return ChosenMove.moveBack();
        }
        else {
            return ChosenMove.moveNext(availableMoves.get(cellNumber - 1));
        }
    }

    public static void printFieldWithAvailableMoves(Field field, List<Point> availableMoves) {
        for (int i = 0; i < field.getSize(); ++i) {
            System.out.printf("%s\t", i + 1);
            for (int j = 0; j < field.getSize(); ++j) {
                System.out.print("|");

                int x = i, y = j;
                var findResult = availableMoves.stream().filter(point -> point.x() == x && point.y() == y).findFirst();
                if (findResult.isPresent()) {
                    System.out.printf("\t%s\t", availableMoves.indexOf(findResult.get()) + 1);
                    continue;
                }

                var point = new Point(i, j);
                var cell = field.getChipAt(point);
                if (cell == null) {
                    System.out.print("\t-\t");
                    continue;
                }
                switch (cell) {
                    case Black -> System.out.print("\t●\t");
                    case White -> System.out.print("\t○\t");
                }
            }
            System.out.println("|");
        }
        System.out.println(" \t \t" + String.join("\t \t", COLUMNS));
    }

    public static void printGameResult(GameResult gameResult) {
        var winner = gameResult.blackPlayerScore() > gameResult.whitePlayerScore() ? "ЧЕРНЫЕ" : "БЕЛЫЕ";
        System.out.printf("ИГРА ЗАВЕРШЕНА!%nРЕЗУЛЬТАТЫ:%nБЕЛЫЕ набрали %s очков%nЧЕРНЫЕ набрали %s очков%nПОБЕДИЛИ %s%n%n",
                gameResult.whitePlayerScore(), gameResult.blackPlayerScore(), winner);
    }

    public static void printBestPlayerScore(int score, ChipType playerChip) {
        var stringPlayer = playerChip == ChipType.White ? "БЕЛЫХ" : "ЧЁРНЫХ";
        System.out.printf("ЛУЧШИЙ РЕЗУЛЬТАТ %s : %s ОЧКОВ%n", stringPlayer, score);
    }
}
