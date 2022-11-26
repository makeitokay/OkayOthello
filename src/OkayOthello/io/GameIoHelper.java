package OkayOthello.io;

import OkayOthello.core.Field;
import OkayOthello.core.Point;

import java.util.ArrayList;
import java.util.List;

public class GameIoHelper {
    private static final List<String> COLUMNS = List.of("A", "B", "C", "D", "E", "F", "G", "H");

    public static Point getMoveFromPlayer(Field field, List<Point> availableMoves) {
        printFieldWithAvailableMoves(field, availableMoves);
        System.out.println("Выберите номер ячейки, в которую хотите сходить");
        var pointIndex = IoHelper.GetNumberFromInput(1, availableMoves.size()) - 1;
        return availableMoves.get(pointIndex);
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
}
