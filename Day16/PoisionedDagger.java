package Day16;

// 4
// 2 5
// 1 5
// 3 10
// 2 4 10
// 5 3
// 1 2 4 5 7
// 4 1000
// 3 25 64 1337

// 3
// 4
// 1
// 470
import java.util.Scanner;

public class PoisionedDagger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            long h = scanner.nextLong();

            int[] attacks = new int[n];
            for (int j = 0; j < n; j++) {
                attacks[j] = scanner.nextInt();
            }

            System.out.println(helper(n, h, attacks));
        }

        scanner.close();
    }

    public static long helper(int n, long h, int[] attacks) {
        long start = 1;
        long end = h;
        long ans = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (valid(mid, attacks, h)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static boolean valid(long mid, int[] attacks, long h) {
        long totalDamage = 0; 
        for (int i = 0; i < attacks.length - 1; i++) {
            if (attacks[i + 1] - attacks[i] < mid) {
                totalDamage += (attacks[i + 1] - attacks[i]);
            } else {
                totalDamage += mid;
            }
        }
        totalDamage += mid; 
        return totalDamage >= h;
    }
}
