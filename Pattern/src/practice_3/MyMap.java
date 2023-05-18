package practice_3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyMap<T, E> implements Map<T, E> {
    Map<T, E> x = new HashMap<>();
    private static final Lock lock = new ReentrantLock();
    @Override
    public int size() {
        lock.lock();
        int y = x.size();
        lock.unlock();
        return y;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean y = x.isEmpty();
        lock.unlock();
        return y;
    }

    @Override
    public boolean containsKey(Object key) {
        lock.lock();
        boolean y = x.containsKey(key);
        lock.unlock();
        return y;
    }

    @Override
    public boolean containsValue(Object value) {
        lock.lock();
        boolean y = x.containsValue(value);
        lock.unlock();
        return y;
    }

    @Override
    public E get(Object key) {
        lock.lock();
        E y = x.get(key);
        lock.unlock();
        return y;
    }

    @Override
    public E put(T key, E value) {
        lock.lock();
        E y = x.put((T) key, (E) value);
        lock.unlock();
        return y;
    }

    @Override
    public E remove(Object key) {
        lock.lock();
        E y = x.remove(key);
        lock.unlock();
        return y;
    }

    @Override
    public void putAll(Map<? extends T, ? extends E> m) {
        lock.lock();
        x.putAll(m);
        lock.unlock();
    }

    @Override
    public void clear() {
        lock.lock();
        x.clear();
        lock.unlock();
    }

    @Override
    public Set<T> keySet() {
        lock.lock();
        Set<T> y = x.keySet();
        lock.unlock();
        return y;
    }

    @Override
    public Collection<E> values() {
        lock.lock();
        Collection<E> y = x.values();
        lock.unlock();
        return y;
    }

    @Override
    public Set<Entry<T, E>> entrySet() {
        lock.lock();
        Set<Entry<T, E>> y = x.entrySet();
        lock.unlock();
        return y;
    }
}
