package Day12;

import java.util.*;



public class GoodSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String s2 = sc.next();
        int k = sc.nextInt();

        Node head = new Node();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int bad = 0;
            Node curr = head;

            for (int j = i; j < s.length(); j++) {
                int c = s.charAt(j) - 'a';

                if (s2.charAt(c) == '0') {
                    bad++;
                }

                if (bad > k) {
                    break;
                }

               
                if (curr.arr[c] == null) {
                    curr.arr[c] = new Node();
                    ans++;
                }

                curr = curr.arr[c];
            }
        }

        System.out.println(ans);
    }
}
class Node {
    Node[] arr = new Node[26];
}