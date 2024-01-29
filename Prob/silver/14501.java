import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static int[] T;
    static int[] P;
    static Integer[] memo;
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(bf.readLine());
        T = new int[num];
        P = new int[num];
        memo = new Integer [num+1];
        for(int i=0; i<num ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i]= Integer.parseInt(st.nextToken());
        }
        System.out.println(top_down(0));
        bf.close();
    }
    static int top_down(int i){
        if(i >= num){
            return 0;
        }
        if(memo[i]==null){
            if(i+T[i]> num){
                memo[i] = top_down(i+1);
            }
            else {
                memo[i] = Math.max(top_down(i + 1), top_down(i + T[i]) + P[i]);
            }
        }
        return memo[i];
    }

}
