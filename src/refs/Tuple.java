package refs;

import interfaces.TupleInterface;

public class Tuple<T> implements TupleInterface<T> {
  Object[] arr;
  private int capacity;

  public Tuple(int capacity) {
    arr = new Object[capacity];
    this.capacity = capacity;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T get(int index) {
    return (T) arr[index % capacity];
  }

  @Override
  public void add(T el) {
    boolean foundNull = false;
    for (int i = 0; i < capacity; i++) {
      if (arr[i] == null) {
        arr[i] = el;
        foundNull = true;
        break;
      }
    }
    if (foundNull) {
      Object[] newArr = new Object[capacity * 2];
      for (int i = 0; i < capacity; i++) {
        newArr[i] = arr[i];
      }
      arr = newArr;
      arr[capacity] = el;
      capacity *= 2;
    }
  }

  @Override
  public void add(T el, int index) {
    while (index >= capacity) {
      int k = (index / capacity) + 1;
      Object[] newArr = new Object[capacity * k];
      for (int i = 0; i < capacity; i++) {
        newArr[i] = arr[i];
      }
      arr = newArr;
      capacity *= k;
    }
    arr[index] = el;
  }

  @Override
  public void remove(int index) {
    arr[index] = null;
  }

  @Override
  public void remove(T el) {
    for (int i = 0; i < capacity; i++) {
      if (arr[i] == el) {
        arr[i] = null;
      }
    }
  }

  @Override
  public boolean isEmpty() {
    return false;
  }
}
