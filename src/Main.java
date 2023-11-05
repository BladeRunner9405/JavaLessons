import refs.MyLinkedList;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.remove(2);
        myList.printList();
    }
}