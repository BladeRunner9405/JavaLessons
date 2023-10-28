package refs;

import interfaces.MatrixInterface;

public class Matrix<T> implements MatrixInterface<T> {
  Object[][] matrix;
  private int c, r;
  private int cLength, rLength;

  public static void main(String[] args) {
    int cLength = 10;
    int rLength = 15;
    Matrix<Integer> matrix = new Matrix<Integer>(cLength, rLength);
    for (int i = 0; i < cLength * rLength; i++) {
      matrix.add(5 + i);
    }
    for (int i = 0; i < cLength; i++) {
      for (int j = 0; j < rLength; j++) {
        System.out.print(matrix.get(i, j) + "\t");
      }
      System.out.println();
    }
    System.out.println();
    Matrix<Integer> matrix2 = new Matrix<Integer>(new Integer[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(matrix2.get(i, j) + "\t");
      }
      System.out.println();
    }
  }

  public Matrix(T[][] matrix) {
    this.matrix = matrix;
    this.rLength = matrix[0].length;
    this.cLength = matrix.length;
  }

  public Matrix(int cLength, int rLength) {
    this.matrix = new Object[cLength][rLength];
    this.cLength = cLength;
    this.rLength = rLength;
  }

  @Override
  public void add(Object el) {
    matrix[c][r] = el;
    c = (c + (r + 1) / rLength) % cLength;
    r = (r + 1) % rLength;
  }

  @Override
  public void del(int cId, int rId) {
    matrix[cId % cLength][rId % rLength] = 0;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T get(int cId, int rId) {
    return (T) matrix[cId % cLength][rId % rLength];
  }
}
