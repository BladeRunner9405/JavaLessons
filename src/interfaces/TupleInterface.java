package interfaces;

public interface TupleInterface<E> {
  E get(int index);

  void add(E el);

  void add(E el, int index);

  void remove(int index);

  void remove(E el);

  boolean isEmpty();
  // void orElse(int i, T default); ???
}
