package refs;

import interfaces.PairInterface;

public class Pair<L, R> implements PairInterface<L, R> {
  private L left;
  private R right;

  public static void main(String[] args) {
    Pair<Integer, Integer> p = new Pair<>(1, 12);
    Pair<Integer, String> pair = new Pair<>(100, "Name");
    String name = pair.getRight();
    System.out.println(pair.max());
  }

  public Pair(L left, R right) {
    this.left = left;
    this.right = right;
  }

  public L getLeft() {
    return left;
  }

  public void setLeft(L left) {
    this.left = left;
  }

  public R getRight() {
    return right;
  }

  public void setRight(R right) {
    this.right = right;
  }

  @Override
  public Object min() {
    return getMinMax(true);
  }

  @Override
  public Object max() {
    return getMinMax(false);
  }

  @SuppressWarnings("unchecked")
  private Object getMinMax(boolean getMin) {
    if (left instanceof Comparable<?>
        && right instanceof Comparable<?>
        && left.getClass() == right.getClass()) {
      if (((Comparable<Object>) left).compareTo(right) > 0) {
        if (getMin) {
          return right;
        } else {
          return left;
        }
      }
      if (getMin) {
        return left;
      } else {
        return right;
      }
    }
    return null;
  }

  public <T> Pair minMax(T[] arr) {
    T max_ = null;
    T min_ = null;
    T prev = arr[0];
    for (int i = 0; i < arr.length - 1; i++) {
      Pair pair = new Pair<T, T>(arr[i], prev);
      max_ = (T) pair.max();
      min_ = (T) pair.min();
      prev = arr[i];
    }
    return new Pair<T, T>(min_, max_);
  }
}
