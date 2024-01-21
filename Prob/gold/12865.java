import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Integer[][] memo;
    static int[] w;
    static int[] v;
    public static void main(String[] args) throws IOException{
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(bf.readLine());
       int n = Integer.parseInt(st.nextToken());
       int max_w = Integer.parseInt(st.nextToken());
       memo = new Integer[n][max_w+1];
       w = new int[n];
       v = new int[n];

       for(int i=0; i<n ; i++){
            st = new StringTokenizer(bf.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
       }
       System.out.println(top_down(n-1,max_w)); //인덱스 파악하기 쉽게 그냥 n-1 로 호출
       bf.close();
    }
    static int top_down(int n, int k){
        if(n<0)
            return 0;

        if(memo[n][k] == null){
            if(w[n]> k){ //해당 아이템이 최대 무게를 넘어가는 경우
                memo[n][k]=top_down(n-1, k);
            }
            else{
                //1. 자신을 제외하고 연산했을 때와
                //2. 자신을 담는다는 가정 후 연산했을 때 중에서
                //max 값을 저장
                //여기서 "자신"은 해당 인덱스의 item을 의미..
                memo[n][k] = Math.max(top_down(n-1, k), top_down(n-1, k-w[n])+v[n]);
            }
        }
        return memo[n][k];
    }

}
