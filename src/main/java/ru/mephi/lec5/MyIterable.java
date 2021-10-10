package ru.mephi.lec5;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterable {
    public static Iterable<Object> nCopies(Object value, int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Expected count more or equals zero: " + count);
        }
        return new Iterable<Object>() {
            @Override
            public Iterator<Object> iterator() {
                return new Iterator<>() {
                    int rest = count;

                    @Override
                    public boolean hasNext() {
                        return rest > 0;
                    }

                    @Override
                    public Object next() {
                        if (rest <= 0) throw new NoSuchElementException();
                        rest--;
                        return value;
                    }

                    // remove
                };
            }
        };
    }

    public static void main(String[] args) {
        for (Iterator<Object> iterator = nCopies("aa", 5).iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        Iterable<Object> iterable = nCopies("qq", 4);
        for (Object o: iterable) {
            System.out.println(o);
        }
        System.out.println("---");
        iterable.iterator().forEachRemaining(System.out::println);

        Collection<Object> objects = new Collection<Object>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Object> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
    }
}
