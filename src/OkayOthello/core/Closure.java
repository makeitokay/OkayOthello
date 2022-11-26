package OkayOthello.core;

public class Closure {
    private final Point startPoint;
    private final PointDirection direction;
    private final int size;

    public Closure(Point startPoint, PointDirection direction, int size) {
        this.startPoint = startPoint;
        this.direction = direction;
        this.size = size;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public PointDirection getDirection() {
        return direction;
    }

    public int getSize() {
        return size;
    }
}
