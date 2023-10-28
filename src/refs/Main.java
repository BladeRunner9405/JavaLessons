package refs;
import interfaces.IntSequence;
import interfaces.Printable;
import interfaces.SignDeterminant;

public class Main {
  public static void main(String[] args) {
    IntSequence a = IntSequence.of(1, 2, 3);
    while (a.hasNext()) {
      System.out.println(a.next());
    }

    Printable printable =
        new Printable() {
          @Override
          public void print() {
            System.out.println("Test");
          }
        };
    printable.print();

    SignDeterminant signDeterminant = new SignDeterminant() {
      @Override
      public String getSign(int num) {
        if (num > 0){
          return "Положительное число";
        }
        if (num == 0){
          return "Ноль";
        }
        return "Отрицательное число";
      }
    };
    System.out.println(signDeterminant.getSign(14));
    System.out.println(signDeterminant.getSign(0));
  }
}
