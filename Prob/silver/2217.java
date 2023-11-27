import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static int max=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Integer [] Weigh = new Integer[num];

        for(int i=0; i< num ; i++){
            Weigh[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(Weigh,Collections.reverseOrder());

        for(int i=0; i<num ; i++){
            max = Math.max(max, Weigh[i]*(i+1));
        }
        System.out.println(max);

    }

}
