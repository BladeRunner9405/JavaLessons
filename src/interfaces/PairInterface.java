package interfaces;

public interface PairInterface<L, R> {
  L getLeft();

  void setLeft(L left);

  R getRight();

  void setRight(R right);

  Object min();
  Object max();
}
