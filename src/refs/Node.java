package refs;

public class Node<E> {

    E data;
    Node<E> prev;
    Node<E> next;

    Node(E data) {
        this.data = data;
        prev = null;
        next = null;
    }
}