package refs;
import java.util.NoSuchElementException;
import java.util.Stack;
import interfaces.Deque;

public class MyDeque<E> implements Deque<E> {
    private Stack<E> stack1;
    private Stack<E> stack2;

    public MyDeque() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    @Override
    public void addFirst(E e) {
        stack1.push(e);
    }

    @Override
    public void addLast(E e) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(e);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack1.pop();
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        E lastElement = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return lastElement;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return stack1.peek();
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        E lastElement = stack2.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return lastElement;
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    @Override
    public int size() {
        return stack1.size();
    }

    @Override
    public void printDeque() {
        System.out.println(stack1);
    }
}