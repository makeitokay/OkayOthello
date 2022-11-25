package io;

import core.ChipType;
import core.Constants;
import core.Point;

import java.util.List;

public class GameIoHelper {
    public static Point getMoveFromPlayer(ChipType[][] field, List<Point> availableMoves) {
        printFieldWithAvailableMoves(field, availableMoves);
        System.out.println("Выберите номер ячейки, в которую хотите сходить");
        var pointIndex = IoHelper.GetNumberFromInput(1, availableMoves.size()) - 1;
        return availableMoves.get(pointIndex);
    }

    public static void printFieldWithAvailableMoves(ChipType[][] field, List<Point> availableMoves) {
        for (int i = 0; i < Constants.FIELD_SIZE; ++i) {
            for (int j = 0; j < Constants.FIELD_SIZE; ++j) {
                System.out.print("|");

                int x = i, y = j;
                var findResult = availableMoves.stream().filter(point -> point.x() == x && point.y() == y).findFirst();
                if (findResult.isPresent()) {
                    System.out.printf("\t%s\t", availableMoves.indexOf(findResult.get()) + 1);
                    continue;
                }

                var cell = field[i][j];
                if (cell == null) {
                    System.out.print("\t-\t");
                    continue;
                }
                switch (cell) {
                    case Black -> System.out.print("\t●\t");
                    case White -> System.out.print("\t○\t");
                }
            }
            System.out.println();
        }
    }
}