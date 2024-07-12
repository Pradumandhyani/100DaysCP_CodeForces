package Day2;
import java.util.Scanner;
 
public class Subs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        sc.nextLine(); 
        
        for (int tc = 0; tc < t; tc++) {
            // Read the two strings
            String a = sc.nextLine();
            String b = sc.nextLine();
            
            int n = a.length();
            int m = b.length();
            int r = 0;
 
            for (int i = 0; i < m; i++) {
                int k = i;
                int j = 0;
                while (j < n && k < m) {
                    if (a.charAt(j) == b.charAt(k)) {
                        k++;
                    }
                    j++;
                }
                r = Math.max(r, k - i);
            }
 
            System.out.println(n + m - r);
        }
        
        sc.close();
    }
}
