import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(br.readLine());
        int[] list=new int[num];
        int head=0, tail=-1;
        for(int i=0; i<num; i++){
            StringTokenizer stt = new StringTokenizer(br.readLine()," ");
            String st = stt.nextToken();
            if(st.equals("push")){
                int number = Integer.parseInt(stt.nextToken());
                tail++;
                list[tail] = number;
            }
            else if(st.equals("pop")){
                if(tail-head+1 == 0){
                    System.out.println("-1");
                    continue;
                }System.out.println(list[head]);
                list[head]=0;
                head++;
            }
            else if(st.equals("size")){
                System.out.println(tail-head+1);
            }
            else if(st.equals("empty")){
                if(tail-head+1 == 0){
                    System.out.println("1");
                }
                else{
                    System.out.println("0");
                }
            }
            else if(st.equals("front")){
                if(tail-head+1 == 0){
                    System.out.println("-1");
                    continue;
                }
                System.out.println(list[head]);
            }
            else{
                if(tail-head+1 == 0){
                    System.out.println("-1");
                    continue;
                }
                System.out.println(list[tail]);
            }

        }


    }
}
