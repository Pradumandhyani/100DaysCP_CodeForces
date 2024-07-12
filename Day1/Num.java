import java.util.*;
public class Num{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long x = sc.nextLong();
        long temp=x;
        long ans=0;
        
        while(temp>0){
            long rem=temp%10;
            long num=9-rem;
            ans=ans*10+Math.min(rem,num);
            temp/=10;

        }
     
        long number=ans;
        long reversedNumber = 0;

        while (number!= 0) {
            long digit = number % 10; 
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10; 
        }
        System.out.println(reversedNumber);
        
       
    }
}