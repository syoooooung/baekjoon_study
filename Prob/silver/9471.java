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

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            sb.append(st.nextToken()+" ");
            int m = Integer.parseInt(st.nextToken());
            int result = cycle(m);
            sb.append(result+"\n");
        }
        System.out.print(sb);
        bf.close();

    }
    static int cycle(int m){
        int cnt =0;
        int a=1,b=1;
        while(true){
            int tmp = (a+b) % m ;
            a = b;
            b = tmp;
            cnt++;
            if(a==1 && b==1)
                break;
        }
        return cnt;
    }
}
