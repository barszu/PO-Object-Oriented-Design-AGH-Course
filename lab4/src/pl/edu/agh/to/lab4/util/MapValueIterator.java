package pl.edu.agh.to.lab4.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapValueIterator<T, U> implements Iterator<U> {

    private final Iterator<Map.Entry<T, U>> iterator;

    public MapValueIterator(Map<T, U> map) {
        this.iterator = map.entrySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public U next() {
        return iterator.next().getValue();
    }

    @Override
    public void remove() {
        iterator.remove();
    }
}

