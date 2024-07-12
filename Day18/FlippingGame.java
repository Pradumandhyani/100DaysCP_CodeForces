package Day18;

import java.util.Scanner;

public class FlippingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

          int initialOnes = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                initialOnes++;
            }
        }

         if (initialOnes == n) {
            System.out.println(n - 1);
            return;
        }

        int[] transformedArray = new int[n];
        for (int i = 0; i < n; i++) {
            transformedArray[i] = (arr[i] == 1) ? -1 : 1;
        }

        int maxEndingHere = 0, maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxEndingHere += transformedArray[i];
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        int result = initialOnes + maxSoFar;
        System.out.println(result);
    }
}
