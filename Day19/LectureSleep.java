package Day19;

import java.util.Scanner;

public class LectureSleep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        int n = sc.nextInt();
        int k = sc.nextInt();

        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }

        sc.close();

        int initialTheorems = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] == 1) {
                initialTheorems += a[i];
            }
        }

       
        int maxExtraTheorems = 0;
        int currentExtraTheorems = 0;

        for (int i = 0; i < k; i++) {
            if (t[i] == 0) {
                currentExtraTheorems += a[i];
            }
        }

        maxExtraTheorems = currentExtraTheorems;

        for (int i = k; i < n; i++) {
            if (t[i - k] == 0) {
                currentExtraTheorems -= a[i - k];
            }
            if (t[i] == 0) {
                currentExtraTheorems += a[i];
            }
            maxExtraTheorems = Math.max(maxExtraTheorems, currentExtraTheorems);
        }

        int totalTheorems = initialTheorems + maxExtraTheorems;

        System.out.println(totalTheorems);
    }
}
