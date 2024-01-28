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
        int num = Integer.parseInt(bf.readLine());
        while(true){
            if(IsPrime(num) && IsPalindrome(num)){
                System.out.println(num);
                break ;
            }
            num++;
        }
        bf.close();
    }
    static boolean IsPrime(int num){ //소수 판별
        if(num<2){
            return false;
        }
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i ==0) //나눠떨어지면 소수가 아님
                return false; //false 반환
        }
        return true; //나눠떨어지는 수가 없으면 소수이다.
    }
    static boolean IsPalindrome(int num){ //팰린드롬 판별
        String strNum = String.valueOf(num);
        int len = strNum.length();
        for(int i=0; i<len/2 ;i++){
            if(strNum.charAt(i) != strNum.charAt(len-i-1))
                return false;
        }
        return true;
    }
}
