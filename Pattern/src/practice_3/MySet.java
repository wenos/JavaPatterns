package practice_3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySet<E> implements Set {
    Set<E> x = new HashSet<>();
    @Override
    synchronized public int size() {
        return x.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return x.isEmpty();
    }

    @Override
    synchronized public boolean contains(Object o) {
        return x.contains(o);
    }

    @Override
    synchronized public Iterator iterator() {
        return x.iterator();
    }

    @Override
    synchronized public Object[] toArray() {
        return x.toArray();
    }

    @Override
    synchronized public boolean add(Object o) {
        return x.add((E) o);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return x.remove(o);
    }

    @Override
    synchronized public boolean addAll(Collection c) {
        return x.addAll(c);
    }

    @Override
    synchronized public void clear() {
        x.clear();
    }

    @Override
    synchronized public boolean removeAll(Collection c) {
        return x.removeAll(c);
    }

    @Override
    synchronized public boolean retainAll(Collection c) {
        return x.retainAll(c);
    }

    @Override
    synchronized public boolean containsAll(Collection c) {
        return x.containsAll(c);
    }

    @Override
    synchronized public Object[] toArray(Object[] a) {
        return x.toArray(a);
    }
}
