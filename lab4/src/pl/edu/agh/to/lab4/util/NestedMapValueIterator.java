package pl.edu.agh.to.lab4.util;

import java.util.*;

public class NestedMapValueIterator<A, B> implements Iterator<B> {
//    for Map<A, Collection<B>> -> nestedMap

    private Iterator<Map.Entry<A, Collection<B>>> outerIterator;
    private Iterator<B> innerIterator;

    public NestedMapValueIterator(Map<A, Collection<B>> nestedMap) {
        List<Map.Entry<A, Collection<B>>> entries = new ArrayList<>(nestedMap.entrySet());
        this.outerIterator = entries.iterator();
        if (outerIterator.hasNext()) {
            this.innerIterator = outerIterator.next().getValue().iterator();
        }
    }

    @Override
    public boolean hasNext() {
        if (innerIterator == null) {
            return false;
        }
        if (innerIterator.hasNext()) {
            return true;
        }
        while (outerIterator.hasNext()) {
            innerIterator = outerIterator.next().getValue().iterator();
            if (innerIterator.hasNext()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public B next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return innerIterator.next();
    }

    @Override
    public void remove() {
        innerIterator.remove();
    }
}
