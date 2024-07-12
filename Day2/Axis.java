package Day2;
import java.util.*;

public class Axis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline after integer input
        
        while (n-- > 0) {
            int xi = sc.nextInt();
            int yi = sc.nextInt();
            
            // Calculate minimum moves to reach or exceed yi
            int minMoves = (int) Math.ceil((double) yi / 2);
            
            // Check if Monocarp can collect the coin
            if (minMoves >= 0 && minMoves <= xi) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        sc.close();
    }
}
