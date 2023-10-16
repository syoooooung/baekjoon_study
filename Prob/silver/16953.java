import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long a,b;
    static long cnt=1;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        a=sc.nextLong();
        b= sc.nextLong();

        while(a!=b){
            if(a>b){
                cnt=-1;
                break;
            }
            if(b%10==1){
                b/=10;
            }
            else if( b%2 ==0){
                b/=2;
            }
            else{
                cnt=-1;
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
        return ;
    }


}
