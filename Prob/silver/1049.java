import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int need_num = sc.nextInt();
        int loop = sc.nextInt();
        int min_bind=1001, min_one=1001;
        for(int i=0; i<loop; i++){
            int bind = sc.nextInt();
            if(min_bind> bind){
                min_bind = bind;
            }
            int one = sc.nextInt();
            if(min_one > one){
                min_one = one;
            }
        }
        int result=0;
        result = ((int)(need_num/6)*min_bind);
        result += (need_num%6)*min_one;

        if(min_bind > min_one*6){
            result = need_num* min_one;
        }
        else if((((int)(need_num/6)+1)*min_bind) < result){
            result = ((int)(need_num/6)+1)*min_bind;
        }

        System.out.println(result);

        //case 1 min_bind가 min_one*6보다 비싸면 min_one으로만 계산
        //줄을 더 사더라도 min_bind로만 산게 더 쌀 경우 min_bound로만 계산
    }

}
