package refs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator<T> implements Iterator<T> {

    private Node<T> current;

    public MyIterator(Node<T> head) {
        current = (Node<T>) head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T data = current.data;
        current = current.next;
        return data;
    }

    public boolean hasPrevious() {
        return current.prev != null;
    }

    public T previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        current = current.prev;
        return current.data;
    }
}