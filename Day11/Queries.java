package Day11;
import java.util.*;

public class Queries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] dp=new int[s.length()];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=dp[i-1];
            }
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(dp[r-1]-dp[l-1]);
        }
        sc.close();
    }

}
