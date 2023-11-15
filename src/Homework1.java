import java.math.BigInteger;
import java.util.Arrays;

public class Homework1 {

    public static void main(String[] args) {
        // тут можете тестировать ваш код

        convert(10);
        System.out.println(normalize(721));
        System.out.println(max(10, 12, -14));
        System.out.println(fact(12));
        System.out.println(fact(BigInteger.valueOf(30)));
        multiplTable();
        System.out.println(average(1, 2, 3, 4, 5, 6, 7));
        System.out.println(isMagicSquare(new int[][]{
                {16, 3, 2, 13},
                {5, 10, 11, 8},
                {9, 6, 7, 12},
                {4, 15, 14, 1}}));
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(sort(new int[]{2, 1, 45, 34, 12, 2})));
        System.out.println(Arrays.toString(removeExtra(new int[]{2, 1, 45, 2, 34, 1, 12, 2}, 2)));
    }

    // task 1
    static void convert(int arg) {
        System.out.println(Integer.toBinaryString(arg));
        System.out.println(Integer.toOctalString(arg));
        System.out.println(Integer.toHexString(arg));
    }


    // task 2
    static int normalize(int angle) {
        return Math.floorMod(angle, 360);
    }


    // task 3
    static int max(int x, int y, int z) {
        int m1;
        int m2;
        if (x > y) {
            m1 = x;
        } else {
            m1 = y;
        }

        if (z > y) {
            m2 = z;
        } else {
            m2 = y;
        }

        int m;
        if (m1 > m2) {
            m = m1;
        } else {
            m = m2;
        }
        return m2;
    }


    // task 4
    static int fact(int n) {
        if (n < 0) {
            return -1;
        }
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }


    // task 5
    static BigInteger fact(BigInteger n) {
        BigInteger S = BigInteger.ONE;
        for (BigInteger a = BigInteger.ONE; !n.equals(a); a = a.add(BigInteger.ONE)) {
            S = S.multiply(a);
        }
        S = S.multiply(n);
        return S;
    }

    // task 6
    static void multiplTable() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }


    // task 7
    static double average(int... nums) {
        if (nums.length == 0) {
            return 0;
        }
        int S = 0;
        for (int a : nums) {
            S += a;
        }
        return (float) S / nums.length;
    }


    // task 8
    static boolean isMagicSquare(int[][] square) {
        if (square.length == 0) return false;
        for (int[] arg : square) if (square.length != arg.length) return false;
        int S = 0, currS = 0;
        boolean first = true;
        for (int[] line : square) {
            currS = 0;
            for (int a : line) currS += a;
            if (first) {
                S = currS;
                first = false;
            } else if (S != currS) return false;
        }
        currS = 0;
        for (int i = 0; i < square.length; i++) currS += square[i][i];
        if (S != currS) return false;

        currS = 0;
        for (int i = 0; i < square.length; i++) currS += square[i][square.length - 1 - i];
        if (S != currS) return false;

        return true;
    }


    // task 9
    static int[] reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int a = arr[i];
            int b = arr[arr.length - i];
            arr[arr.length - i] = a;
            arr[i] = b;
        }
        return arr;
    }


    // task 10
    static int[] sort(int[] arr) {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < arr.length - 1; i++) {
                int a = arr[i];
                int b = arr[i + 1];
                if (a > b) {
                    arr[i + 1] = a;
                    arr[i] = b;
                    changed = true;
                }
            }
        }
        return arr;
    }

    public static int countNumInArr(int[] arr, int badNum) {
        int c = 0;
        for (int a : arr) if (a == badNum) c += 1;
        return c;
    }

    // task 11
    static int[] removeExtra(int[] arr, int n) {
        int[] newArr = new int[arr.length - countNumInArr(arr, n)];
        int i = 0;
        for (int a : arr) {
            if (a != n) {
                newArr[i] = a;
                i++;
            }
        }
        return newArr;
    }
}