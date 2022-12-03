package OkayOthello.repository;

import java.util.ArrayList;

public abstract class Repository<E> {
    protected final ArrayList<E> items;

    public Repository() {
        items = new ArrayList<>();
    }

    public void add(E element) {
        items.add(element);
    }

    public int count() {
        return items.size();
    }
}
