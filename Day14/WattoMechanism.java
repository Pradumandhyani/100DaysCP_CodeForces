package Day14;

import java.util.*;

public class WattoMechanism {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); 
        Map<Integer, List<String>> map = new HashMap<>();
        
        List<String> initialStrings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s=sc.nextLine();
            int len=s.length();
            map.computeIfAbsent(len, k -> new ArrayList<>()).add(s);
            initialStrings.add(s);
        }
        
      
        List<String> queries = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            queries.add(sc.nextLine());
        }

        for (String query : queries) {
            if (helper(initialStrings, query,map)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        sc.close();
    }

    public static boolean helper(List<String> initialStrings, String query,Map<Integer, List<String>> map) {
        int len = query.length();
        
        if(map.containsKey(len)){
            List<String>list=map.get(len);
            for(int i=0;i<list.size();i++){
                if(valid(query,list.get(i))){
                    return true;
                }
            }
        }
       
        return false;
    }

    public static boolean valid(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}
