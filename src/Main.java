import refs.MyDeque;
import refs.MyLinkedList;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        MyDeque<Integer> myList = new MyDeque<>();
        myList.addFirst(1);
        myList.addFirst(2);
        myList.addFirst(3);
        myList.addLast(2);
        myList.printDeque();
        myList.removeLast();
        myList.printDeque();
        myList.removeLast();
        myList.printDeque();
        myList.removeLast();
        myList.printDeque();
        System.out.println(myList.peekFirst());

    }
}