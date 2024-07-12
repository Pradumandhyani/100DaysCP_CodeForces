package Day15;
import java.util.Scanner;

public class SegmentOccurences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine(); 

        String s = sc.nextLine();
        String t = sc.nextLine();

       
        int[] occurrences = new int[n + 1];
        for (int i = 0; i <= n - m; i++) {
            if (s.substring(i, i + m).equals(t)) {
                occurrences[i + 1] = occurrences[i] + 1;
            } else {
                occurrences[i + 1] = occurrences[i];
            }
        }

        
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            if (r - l + 1 < m) {
               
                System.out.println(0);
            } else {
                
                System.out.println(occurrences[r - m + 1] - occurrences[l - 1]);
            }
        }

        sc.close();
    }
}
