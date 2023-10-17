import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String[]a = S.split("");
        int one=0, zero=0; //1구간 수, 0구간 수

        if(a[0].equals("0"))
            zero++;
        else
            one++;
        for(int i=1; i< S.length();i++){
            if(!a[i].equals(a[i-1])){
                if(a[i].equals("0"))
                    zero++;
                else
                    one++;
            }
        }

        if(zero<one){
            System.out.println(zero);
        }
        else{
            System.out.println(one);
        }

    }


}
