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
    static int n;
    static int[] number;
    static int[] operator=new int[4];
    static int Max=Integer.MIN_VALUE;
    static int Min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        number = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n ; i++){
            number[i]= Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<4 ; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(number[0],1);
        System.out.println(Max+"\n"+Min);
        bf.close();
    }
    static void dfs(int num, int index){
        if(index==n) {
            Max = Math.max(Max, num);
            Min = Math.min(Min, num);
            return;
        }
        for(int i=0; i<4; i++){
            if(operator[i]>0){
                operator[i]--;
                switch(i){
                    case 0 : dfs(num + number[index], index+1); break;
                    case 1 : dfs(num-number[index], index+1); break;
                    case 2 : dfs(num * number[index], index+1); break;
                    case 3 : dfs(num/number[index], index+1); break;
                }
                operator[i]++;
            }
        }
    }

}
