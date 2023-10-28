package refs;

public class Task9 {
  public static void main(String[] args) {
    try {
      int[] m = new int[2];
      m[8] = 5;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }
  }
}
