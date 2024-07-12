package Day15;
import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(findPassword(s));
        sc.close();
    }

    public static String findPassword(String s) {
        int n = s.length();
        int[] pi = new int[n];
        computePrefixFunction(s, pi);

        int length = pi[n - 1];

        if (length == 0) {
            return "Just a legend";
        }

        for (int i = 1; i < n - 1; i++) {
            if (pi[i] == length) {
                return s.substring(0, length);
            }
        }

        length = pi[length - 1];
        if (length == 0) {
            return "Just a legend";
        }

        return s.substring(0, length);
    }

    private static void computePrefixFunction(String s, int[] pi) {
        int n = s.length();
        int k = 0;
        for (int i = 1; i < n; i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i)) {
                k = pi[k - 1];
            }
            if (s.charAt(k) == s.charAt(i)) {
                k++;
            }
            pi[i] = k;
        }
    }
}
