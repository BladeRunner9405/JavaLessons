import java.util.*;

interface BaseSet<E> extends Iterable<E> {

    void add(E e);

    void remove(Object o);

    boolean contains(Object o);

    boolean equals(Object o);

    boolean isEmpty();

    int size();

    void clear();
}

public class MyHashSet<E> implements BaseSet<E> {
    private static final int DEFAULT_CAPACITY = 1 << 4;
    private static final int MAX_CAPACITY = 1 << 30;
    private static final float LOAD_FACTOR = 0.75f;
    private Node<E>[] table;
    private int size;
    private final float loadFactor;
    private int threshold;

    public MyHashSet() {
        this(DEFAULT_CAPACITY, LOAD_FACTOR);
    }

    public static void main(String[] args) {
        BaseSet<Integer> hashSet = new MyHashSet<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            hashSet.add(i);
            numbers.add(i);
            System.out.println(i == hashSet.size());
        }
        System.out.println(hashSet);
        Iterator<Integer> listIterator = numbers.iterator();
        Iterator<Integer> hashSetIterator = hashSet.iterator();

        while (hashSetIterator.hasNext()) {
            System.out.println(Objects.equals(hashSetIterator.next(), listIterator.next()));
        }

        hashSet.clear();
    }

    public MyHashSet(int initialCapacity, float loadFactor) {
        if (initialCapacity <= 0 || initialCapacity > MAX_CAPACITY) {
            throw new IllegalArgumentException("Invalid initial capacity");
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Invalid load factor");
        }
        this.table = new Node[initialCapacity];
        this.loadFactor = loadFactor;
        this.threshold = (int) (initialCapacity * loadFactor);
    }

    private static int hash(Object key) {
        if (key == null) {
            return 0;
        }
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = table.length * 2;
        if (newCapacity > MAX_CAPACITY) {
            newCapacity = MAX_CAPACITY;
        }
        Node<E>[] newTable = new Node[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    private void transfer(Node<E>[] newTable) {
        Node<E>[] oldTable = table;
        int oldCapacity = oldTable.length;
        for (int i = 0; i < oldCapacity; i++) {
            Node<E> node = oldTable[i];
            while (node != null) {
                Node<E> next = node.next;
                int index = indexFor(node.hash, newTable.length);
                node.next = newTable[index];
                newTable[index] = node;
                node = next;
            }
        }
    }

    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    @Override
    public void add(E e) {
        if (e == null) {
            throw new NullPointerException("Null elements are not allowed");
        }
        if (size >= threshold) {
            resize();
        }
        int hash = hash(e);
        int index = indexFor(hash, table.length);
        Node<E> node = table[index];
        while (node != null) {
            if (node.hash == hash && Objects.equals(node.key, e)) {
                return; // Element already exists
            }
            node = node.next;
        }
        Node<E> newNode = new Node<>(hash, e, table[index]);
        table[index] = newNode;
        size++;
    }

    @Override
    public void remove(Object o) {
        if (o == null) {
            return;
        }
        int hash = hash(o);
        int index = indexFor(hash, table.length);
        Node<E> node = table[index];
        Node<E> prev = null;
        while (node != null) {
            if (node.hash == hash && Objects.equals(node.key, o)) {
                if (prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        int hash = hash(o);
        int index = indexFor(hash, table.length);
        Node<E> node = table[index];
        while (node != null) {
            if (node.hash == hash && Objects.equals(node.key, o)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyHashSet<?> other = (MyHashSet<?>) o;
        if (size != other.size) {
            return false;
        }
        for (Node<E> node : table) {
            while (node != null) {
                if (!other.contains(node.key)) {
                    return false;
                }
                node = node.next;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = -1;
            private Node<E> currentNode = null;
            private Node<E> nextNode = null;

            {
                findNext();
            }

            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            @Override
            public E next() {
                if (nextNode == null) {
                    throw new NoSuchElementException();
                }
                currentNode = nextNode;
                findNext();
                return currentNode.key;
            }

            @Override
            public void remove() {
                if (currentNode == null) {
                    throw new IllegalStateException();
                }
                MyHashSet.this.remove(currentNode.key);
                currentNode = null;
            }

            private void findNext() {
                if (nextNode != null && nextNode.next != null) {
                    nextNode = nextNode.next;
                    return;
                }
                currentIndex++;
                while (currentIndex < table.length) {
                    if (table[currentIndex] != null) {
                        nextNode = table[currentIndex];
                        return;
                    }
                    currentIndex++;
                }
                nextNode = null;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        sb.append("[");
        for (int i = 0; i < table.length; i++) {
            Node<E> node = table[i];
            if (table[i] != null && !first) {
                sb.append(", ");
            }
            while (node != null) {
                sb.append(node.key);
                if (first) {
                    first = false;
                }

                if (node.next != null) {
                    sb.append(", ");
                }
                node = node.next;
            }
        }

        sb.append("]");
        return sb.toString();
    }

    static class Node<T> {
        final int hash;
        final T key;
        Node<T> next;

        public Node(int hash, T key, Node<T> next) {
            this.hash = hash;
            this.key = key;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?> node = (Node<?>) o;
            return hash == node.hash && Objects.equals(key, node.key) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(hash, key, next);
        }

        @Override
        public String toString() {
            return key.toString();
        }
    }
}