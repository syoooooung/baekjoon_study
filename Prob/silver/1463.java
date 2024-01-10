import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Integer memo[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        memo = new Integer[num+1];
        memo[0] = memo[1]=0;
        System.out.println(top_down(num));
    }
    static int top_down(int num){
        if(memo[num] == null){
            if(num%6 == 0){
                memo[num]= Math.min(top_down(num-1), Math.min(top_down(num/3), top_down(num/2))) +1;
            }
            else if(num%3 ==0){
                memo[num] = Math.min(top_down(num/3), top_down(num-1))+1;
            }
            else if(num%2 ==0){
                memo[num] = Math.min(top_down(num/2), top_down(num-1) )+1;
            }
            else{
                memo[num]= top_down(num-1)+1;
            }
        }
        return memo[num];
    }
}
