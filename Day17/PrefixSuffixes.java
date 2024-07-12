package Day17;

// ABACABA
// outputCopy
// 3
// 1 4
// 3 2
// 7 1
// inputCopy
// AAA
// outputCopy
// 3
// 1 3
// 2 2
// 3 1
import java.util.Scanner;
 
public class PrefixSuffixes {
    private static final int N = 200005;
    private static int n;
    private static int[] dp = new int[N];
    private static int[] nex = new int[N];
    private static boolean[] vis = new boolean[N];
    private static int ans;
    private static char[] s = new char[N];
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        n = input.length();
 
        for (int i = 1; i <= n; i++) {
            s[i] = input.charAt(i - 1);
        }

        for (int i = 2, j = 0; i <= n; i++) {
            while (j > 0 && s[i] != s[j + 1]) {
                j = nex[j];
            }
            if (s[i] == s[j + 1]) {
                j++;
            }
            nex[i] = j;
        }
 
        for (int i = n; i >= 1; i--) {
            dp[i]++;
            dp[nex[i]] += dp[i];
        }
 
        for (int i = nex[n]; i > 0; i = nex[i]) {
            ans++;
            vis[i] = true;
        }
 
        vis[n] = true;
        ans++;
 
        System.out.println(ans);
        for (int i = 1; i <= n; i++) {
            if (vis[i]) {
                System.out.println(i + " " + dp[i]);
            }
        }
 
        scanner.close();
    }
}
