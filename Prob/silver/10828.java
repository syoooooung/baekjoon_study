import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int[] stack;
    static int top=-1; //제일위ㅇ에있는 수의idx
    static int bottom=0; //제일 아래에 있는 수의 idx
    public static void main(String[] args) throws IOException{
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stt;
        int num = Integer.parseInt(br.readLine());

        stack = new int [num];
        for(int i=0; i<num ; i++){
            stt = new StringTokenizer(br.readLine(), " ");
            String st = stt.nextToken();
            if(st.equals("push")) {
                int number = Integer.parseInt(stt.nextToken());
                top++;
                stack[top]=number;

            }
            else if (st.equals("pop")){
                if(top-bottom < 0){
                    System.out.println("-1");
                }
                else{
                    System.out.println(stack[top]);
                    stack[top]=0;
                    top--;
                }
            }
            else if(st.equals("size")){
                System.out.println(top-bottom+1);
            }
            else if(st.equals("empty")){
                if(top-bottom < 0){
                    System.out.println("1");
                }
                else{
                    System.out.println("0");
                }
            }
            else if(st.equals("top")){
                if(top-bottom <0){
                    System.out.println("-1");
                }
                else{
                    System.out.println(stack[top]);
                }
            }
        }
    }
}
