import java.util.Objects;

public class IntHolder {
    public int num;

    public IntHolder(int num){
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IntHolder otherNum = (IntHolder) o;
        return num == otherNum.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    public int add(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return num;
        }
        IntHolder otherNum = (IntHolder) o;
        return num + otherNum.num;
    }

    public int mult(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return 0;
        }
        IntHolder otherNum = (IntHolder) o;
        return num * otherNum.num;
    }

    public int div(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return 0;
        }
        IntHolder otherNum = (IntHolder) o;
        return num / otherNum.num;
    }

    public int divRemainder (Object o) {
        if (o == null || getClass() != o.getClass()) {
            return 0;
        }
        IntHolder otherNum = (IntHolder) o;
        return num % otherNum.num;
    }

    public static void swap (IntHolder num1, IntHolder num2) {
        int otherNum = num1.num;
        num1.num = num2.num;
        num2.num = otherNum;
    }
}
