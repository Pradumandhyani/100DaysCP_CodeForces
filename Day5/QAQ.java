// Bort wants to know how many subsequences "QAQ" are in the string Diamond has given. Note that the letters "QAQ" don't have to be consecutive, but the order of letters should be exact.

// Input
// The only line contains a string of length n (1 ≤ n ≤ 100). It's guaranteed that the string only contains uppercase English letters.

// Output
// Print a single integer — the number of subsequences "QAQ" in the string.

// Examples
// inputCopy
// QAQAQYSYIOIWIN
// outputCopy
// 4
// inputCopy
// QAQQQZZYNOIWIN
// outputCopy
// 3
import java.util.*;

public class QAQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(helper(s, "QAQ", 0, "", 0));
        sc.close();
    }

    public static int helper(String s, String t, int idx, String temp, int count) {
        if (temp.equals(t)) {
            return count+1;
        }
        if (idx >= s.length()) {
            return count;
        }

        char ch = s.charAt(idx);

        int take = helper(s, t, idx + 1, temp, count);

        int notTake = 0;
        if (temp.length() < t.length()) {
            notTake = helper(s, t, idx + 1, temp + ch, count);
        }

        return take + notTake;
    }
}
