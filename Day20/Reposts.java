package Day20;
import java.util.*;

public class Reposts {
    static Map<String, List<String>> adj = new HashMap<>();
    static Map<String, Boolean> vis = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < n; i++) {
            String s1 = scanner.next().toLowerCase();
            scanner.next(); 
            String s2 = scanner.next().toLowerCase();

            adj.putIfAbsent(s2, new ArrayList<>());
            adj.putIfAbsent(s1, new ArrayList<>());

            adj.get(s2).add(s1);
            
            adj.get(s1).add(s2);
        }

        System.out.println(dfs("polycarp"));
        scanner.close();
    }

    static int dfs(String s) {
        if (vis.getOrDefault(s, false)) {
            return 0;
        }

        int dist = 0;
        vis.put(s, true);

        for (String neighbor : adj.get(s)) {
            dist = Math.max(dfs(neighbor), dist);
        }

        return dist + 1;
    }
}


