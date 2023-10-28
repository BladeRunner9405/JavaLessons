package refs;

public class Task8 {
  public static void main(String[] args) {
    try {
      String s = null;
      String m = s.toLowerCase();
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());
    }
  }
}
