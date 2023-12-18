import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
        static Integer memo[];
        static int stair[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        memo = new Integer[num+1];
        stair = new int [num+1];

        for(int i=1; i<=num ; i++){
            stair[i]=Integer.parseInt(br.readLine());
        }
        memo[0]=0;
        memo[1]=stair[1];
        if(num >=2){
            memo[2]=stair[1]+stair[2];
        }
        System.out.println(top_down(num));
    }
    static int top_down(int num){
        if(memo[num]==null){
            memo[num]=Math.max(top_down(num-2), top_down(num-3)+stair[num-1])+stair[num];
        }
        return memo[num];
    }
}
