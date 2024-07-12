package Day16;

import java.util.Scanner;

public class LCMProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            if (2 * l <= r) {
                System.out.println(l + " " + 2 * l);
            } else {
                System.out.println("-1 -1");
            }
        }

        scanner.close();
    }
}

