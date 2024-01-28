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
        int period=1500000;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine()) % period;
        n=n%period;
        long[] pibo = new long[period+1];

        pibo[0]=0;
        pibo[1]=1;
        for(int i=2 ; i<=period ; i++){
            pibo[i] = (pibo[i-1]+ pibo[i-2])%1000000;
        }
        System.out.println(pibo[(int)n]);

    }
}
