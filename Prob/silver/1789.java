import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long S= sc.nextLong();
        long sum=0, result=0;

        for(long i=1 ; i<S+1 ; i++){
            sum += i;
            result = i;
            if(sum>S){
                result-=1;
                break;
            }
        }
        System.out.println(result);
        return ;
    }
}
