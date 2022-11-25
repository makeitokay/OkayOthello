package core;

public class PointDirection {
    public static final PointDirection NORTH = new PointDirection(-1, 0);
    public static final PointDirection NORTHEAST = new PointDirection(-1, 1);
    public static final PointDirection EAST = new PointDirection(0, 1);
    public static final PointDirection SOUTHEAST = new PointDirection(1, 1);
    public static final PointDirection SOUTH = new PointDirection(1, 0);
    public static final PointDirection SOUTHWEST = new PointDirection(1, -1);
    public static final PointDirection WEST = new PointDirection(0, -1);
    public static final PointDirection NORTHWEST = new PointDirection(-1, -1);

    public static final PointDirection[] POINT_DIRECTIONS = new PointDirection[] {
            NORTH,
            NORTHEAST,
            EAST,
            SOUTHEAST,
            SOUTH,
            SOUTHWEST,
            WEST,
            NORTHWEST
    };

    private final int dx;
    private final int dy;

    private PointDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
