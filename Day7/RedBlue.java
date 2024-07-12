package Day7;

import java.util.*;

public class RedBlue {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int[] r=new int[n];
            for(int j=0;j<n;j++){
                r[j]=sc.nextInt();
            }
            int m=sc.nextInt();
            int[] b=new int[m];
            for(int j=0;j<m;j++){
                b[j]=sc.nextInt();
            }
            System.out.println(helper(r,b));
        }
        sc.close();
    }
    public static int helper(int[] r,int[] b){
        int sum1=0;
        int max=0;
        for(int i=0;i<r.length;i++){
            sum1+=r[i];
            max=Math.max(sum1,max);
        }
        int sum2=0;
        int max2=0;
        for(int i=0;i<b.length;i++){
            sum2+=b[i];
            max2=Math.max(sum2,max2);
        }
        return max+max2;
    }
}
