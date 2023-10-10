public class Main {
  public static void main(String[] args) {
    IntSequence a = IntSequence.of(1, 2, 3);
    while (a.hasNext()) {
      System.out.println(a.next());
    }
  }
}
