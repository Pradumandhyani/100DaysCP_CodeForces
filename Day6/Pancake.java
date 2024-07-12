package Day6;

import java.util.*;
public class Pancake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n=sc.nextInt();
            int[] arr=new int[n];
            for (int j = 0; j < n; j++) {
                arr[j]=sc.nextInt();
            }

            helper(arr,n);
        }
        sc.close();
    }
    public static void helper(int[] arr,int n){
        int[] ans=new int[n];
        int count=0;
        
       for(int i=n-1;i>=0;i--){
        count=Math.max(count,arr[i]);
        if(count>0){
            ans[i]=1;
            count--;
        }
       }
       for(int k=0;k<n;k++){
        System.out.print(ans[k]+" ");
       }
       System.out.println();
    }
}
