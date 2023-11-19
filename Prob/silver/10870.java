import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        System.out.println(fibo(num));
    }
    static long fibo(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fibo(n-1)+fibo(n-2);
    }
}
