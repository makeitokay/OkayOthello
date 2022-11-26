package OkayOthello.core;

public class Utils {
    public static ChipType swapChip(ChipType chip) {
        return chip == ChipType.Black ? ChipType.White : ChipType.Black;
    }

    public static boolean isEdgePoint(Field field, Point point) {
        int x = point.x();
        int y = point.y();
        return x == field.getSize() - 1 || y == field.getSize() - 1
                || x == 0 || y == 0;
    }

    public static boolean isCornerPoint(Field field, Point point) {
        int x = point.x();
        int y = point.y();
        return (x == 0 && y == 0) || (x == 0 && y == field.getSize() - 1)
                || (x == field.getSize() - 1 && y == 0) || (x == field.getSize() - 1 && y == field.getSize() - 1);
    }
}
