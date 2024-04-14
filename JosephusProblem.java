import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JosephusProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of People (N): ");
        int N = scanner.nextInt();
        if (N <= 0) {
            System.out.println("Invalid input for the number of people.");
            return;
        }

        System.out.print("Elimination Interval (K): ");
        int K = scanner.nextInt();
        if (K <= 0) {
            System.out.println("Invalid input for the elimination interval.");
            return;
        }

        System.out.print("Starting Index (S): ");
        int S = scanner.nextInt();
        if (S <= 0 || S > N) {
            System.out.println("Invalid input for the starting index.");
            return;
        }

        int lastPersonIndex = findLastPersonIndex(N, K, S);
        System.out.println("The last person remaining is at index " + lastPersonIndex);
    }

    private static int findLastPersonIndex(int N, int K, int S) {
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        int currentIndex = S - 1; // Adjust for 0-based indexing
        while (people.size() > 1) {
            currentIndex = (currentIndex + K - 1) % people.size();
            people.remove(currentIndex);
        }

        return people.get(0);
    }
}

/* OUTPUT 
 * Number of People (N): 7
 * Elimination Interval (K): 2
 * Starting Index (S): 1
 * The last person remaining is at index 7
 */



