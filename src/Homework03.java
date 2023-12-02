import java.util.Arrays;

public class Homework03 {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] B = new int[][]{{7, 10}, {8, 11}, {9, 12}};
        System.out.println(Arrays.deepToString(matrixMult(A, B)));
    }

    public static boolean AisDdivByB(int a, int b) { // проверка на чётность
        return (a % b) == 0;
    }

    public static int[][] AplusB(int[][] A, int[][] B) { // сложение матриц
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public static int[][] transposition(int[][] A) { // транспонирование матриц
        int[][] result = new int[A[0].length][A.length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;
    }

    public static int[][] matrixMult(int[][] A, int[][] B) { // умножение матриц
        int[][] result = new int[B[0].length][A.length];

        for (int i = 0; i < A.length; i++) {
            int[] line1 = A[i];
            for (int j = 0; j < B[0].length; j++) {
                int S = 0;
                for (int k = 0; k < B.length; k++) {
                    S += line1[k] * B[k][j];
                }
                result[i][j] = S;
            }
        }
        return result;
    }
}
