import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(bf.readLine());
        String list[] = new String[num];
        int [] alpha= new int [26];

        for (int i=0; i<num ; i++){
            list[i]= bf.readLine(); //입력 받아오기
        }
        for(int i=0; i< num ; i++){
            int tmp = (int) Math.pow(10, list[i].length()-1); //ABC라면 100을 a위치에 10을 B에, 1을 C 위치에 더해준다.
            for( int j=0; j< list[i].length(); j++){
                alpha[(int)list[i].charAt(j)-65] += tmp; //A의 아스키코드65이므로 A부터 시작하는 배열에 해당하는 값 저장해주기
                tmp /= 10; //한자리씩 줄어든다.
            }
        }

        Arrays.sort(alpha); //수를 할당해주기 위해 정렬해주기.
        int idx = 9;
        int sum = 0;
        for(int i=alpha.length-1 ; i>=0; i--){
            if(alpha[i]==0)
                break;
            sum+= alpha[i]*idx;
            idx--;
        }
        System.out.println(sum);
    }
}
