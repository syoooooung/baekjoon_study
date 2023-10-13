import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine()); //입력받을 숫자의 수
        int[] list = new int[num];
        StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<num ; i++){
            list[i]= Integer.parseInt(stt.nextToken());
        }
        Arrays.sort(list);
        int num2 = Integer.parseInt(br.readLine());
        stt = new StringTokenizer(br.readLine(), " ");
        int[] result = new int[num2];
        for(int i=0; i<num2; i++){
            int number = Integer.parseInt(stt.nextToken());
            if( search(list, number) == -1){
                result[i]=0;
            }
            else{
                result[i]=1;
            }
        }
        for(int i=0; i<num2; i++)
            System.out.println(result[i]);
    }

    static int search(int[]arr, int findnum){
        int low =0;
        int hi= arr.length -1;
        while( low <= hi){
            int mid = (int)(low +hi) /2;

            if(findnum < arr[mid]){
                hi = mid-1;
            }
            else if(findnum >arr[mid]){
                low = mid+1;
            }
            else{
                return arr[mid];
            }
        }

        return -1;
    }



}
