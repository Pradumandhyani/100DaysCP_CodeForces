package Day13;
// inputCopy
// 5
// a
// abcdfdcecba
// abbaxyzyx
// codeforces
// acbba
// outputCopy
// a
// abcdfdcba
// xyzyx
// c
// abba
import java.util.*;

public class PrefixSuffixPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            String ans = findLongestPalindrome(s);
            if (ans.length() == 1) {
                System.out.println(s.charAt(0));
            } else {
                System.out.println(ans);
            }
        }
        sc.close();
    }

    public static String findLongestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        // Find the longest prefix-suffix palindrome
        int prefixLen = 0;
        while (prefixLen < n / 2 && s.charAt(prefixLen) == s.charAt(n - prefixLen - 1)) {
            prefixLen++;
        }

        String prefix = s.substring(0, prefixLen);
        String suffix = new StringBuilder(prefix).reverse().toString();
        String middle = s.substring(prefixLen, n - prefixLen);

        // Find the longest palindromic substring in the middle part
        String longestMiddlePalindrome = findLongestPalindromicSubstring(middle);

        return prefix + longestMiddlePalindrome + suffix;
    }

    public static String findLongestPalindromicSubstring(String s) {
        int n = s.length();
        if (n == 0) return "";

        String rev = new StringBuilder(s).reverse().toString();
        int len = 0;
        String ans = "";
        for (int i = 0; i <= n; i++) {
            if (isPalindrome(s.substring(0, i))) {
                len = i;
                ans = s.substring(0, i);
            }
        }

        int len2 = 0;
        String ans2 = "";
        for (int i = 0; i <= n; i++) {
            if (isPalindrome(rev.substring(0, i))) {
                len2 = i;
                ans2 = rev.substring(0, i);
            }
        }

        if (len > len2) {
            return ans;
        }
        return new StringBuilder(ans2).reverse().toString();
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
