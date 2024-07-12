package Day14;
import java.util.*;

public class Spy {

    
    private static Map<Long, String> wordMap = new HashMap<>();
    private static long[] dp = new long[100001];

    private static void reconstructSentence(int index) {
        if (index == 0) {
            return;
        }
        reconstructSentence((int) (index - wordMap.get(dp[index]).length()));
        System.out.print(wordMap.get(dp[index]) + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next(); 
        int m = sc.nextInt(); 

        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < m; i++) {
            String word = sc.next();
            long hash = 0;
            for (char c : word.toLowerCase().toCharArray()) {
                hash = hash * 31 + c;
            }
            wordMap.put(hash, word);
        }

       
        for (int i = 0; i < n; i++) {
            long hash = 0;
            for (int j = i; j >= 0; j--) {
                hash = hash * 31 + s.charAt(j);
                if (dp[j] != -1 && wordMap.containsKey(hash)) {
                    dp[i + 1] = hash;
                    break;
                }
            }
        }

       
        reconstructSentence(n);

        sc.close();
    }
}
