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
        // Шаг 1: Создаем пустой HashSet<>
        HashSet<Integer> numbers = new HashSet<>();

        // Шаг 2: Заполняем HashSet<> всеми числами от 2 до n
        for (int i = 2; i <= n; i++) {
            numbers.add(i);
        }

        // Шаг 3-4: Применяем решето Эратосфена
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