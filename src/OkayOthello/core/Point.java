package OkayOthello.core;

public record Point(int x, int y) {
    @Override
    public String toString() {
        return "[X = %s, Y = %s]".formatted(x, y);
    }
}
