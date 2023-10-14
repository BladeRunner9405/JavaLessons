public class Main {
    public static void main(String[] args) {
        //        int[] arr =  {1, 2, 3, 4, 3, 4, 5};
        //        for(int a: task11(arr, 3)) System.out.print(a + " ");
        //        task5(BigInteger.TEN);
    }

    public static void task1(int a) {
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toOctalString(a));
        System.out.println(Integer.toHexString(a));
    }

    public static void task2(int a) {
        System.out.println(Math.floorMod(a, 360));
    }

    public static void task3(int a, int b, int c) {
        System.out.println(Math.max(a, Math.max(b, c)));
    }

    public static int fact(int a) {
        if (a < 0) return -1;
        if (a <= 1) return 1;
        else return a * fact(a - 1);
    }

    public static void task4(int a) {
        System.out.println(fact(a));
    }

    public static void task6() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    public static float task7(int... args) {
        int S = 0;
        for (int a : args) S += a;
        return (float) S / args.length;
    }

    public static boolean task8(int[][] args) {
        if (args.length == 0) return false;
        for (int[] arg : args) if (args.length != arg.length) return false;
        int S = 0, currS = 0;
        boolean first = true;
        for (int[] line : args) {
            currS = 0;
            for (int a : line) currS += a;
            if (first) {
                S = currS;
                first = false;
            } else if (S != currS) return false;
        }
        currS = 0;
        for (int i = 0; i < args.length; i++) currS += args[i][i];
        if (S != currS) return false;

        currS = 0;
        for (int i = 0; i < args.length; i++) currS += args[i][args.length - 1 - i];
        if (S != currS) return false;

        return true;
    }

    public static int[] task9(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) newArr[arr.length - 1 - i] = arr[i];
        return newArr;
    }

    public static int[] task10(int[] arr) {
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
        int C = 0;
        for (int a : arr) if (a == badNum) C += 1;
        return C;
    }
}