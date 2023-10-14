import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(br.readLine());

        int[] list=new int[num];
        int idx=0; //써야할 위치!
        for(int i=0; i<num; i++){
            int number = Integer.parseInt(br.readLine());
            if(number==0){
                if(idx>0)
                    idx--;
                list[idx]=0;
            }
            else{
                list[idx]=number;
                idx++;
            }
        }
        int result=0;
        for(int i=0; i<idx ; i++){
            result+=list[i];
        }
        System.out.println(result);
    }
}
