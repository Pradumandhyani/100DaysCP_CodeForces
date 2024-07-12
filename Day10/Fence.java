package Day10;

import java.util.*;

public class Fence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(helper(arr, n, k));
        sc.close();
    }

    public static int helper(int[] arr, int n, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int min = sum;
        int idx = 0;

        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            if (sum < min) {
                min = sum;
                idx = i - k + 1;
            }
        }

        return idx + 1;
    }
}
