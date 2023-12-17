import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> answer = findPrimes(N);
        for (int prime : answer) {
            System.out.print(prime + " ");
        }
    }

    public static List<Integer> findPrimes(int n) {
        HashSet<Integer> numbers = new HashSet<>();

        for (int i = 2; i <= n; i++) {
            numbers.add(i);
        }

        int p = 2;
        while (p * p <= n) {
            if (numbers.contains(p)) {
                for (int i = p * p; i <= n; i += p) {
                    numbers.remove(i);
                }
            }
            p++;
        }
        return numbers.stream().toList();
    }
}