package Day7;

import java.util.*;

public class Pipes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); // Use nextLong() to handle large inputs
        int k = sc.nextInt();
        System.out.println(helper(n, k));
        sc.close();
    }

    public static int helper(long n, int k) {
        long start = 0;
        long end = k - 1;
        n -= 1; // Subtract the initial pipe
        long sum = add(k - 1);
        
        if (sum < n) {
            return -1;
        } else {
            while (start <= end) {
                long mid = start + (end - start) / 2;
                if (sum - add(mid) >= n) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return (int)(k - 1 - end);
    }

    public static long add(long k) { // Use long to handle large sums
        return k * (k + 1) / 2;
    }

    public static boolean isValid(long n, long mid) {
        long totalPipes = 1;
        for (long i = 1; i < mid - 1; i++) {
            if (totalPipes >= n) {
                return true;
            }
            totalPipes += i;
        }
        return totalPipes >= n;
    }
}
