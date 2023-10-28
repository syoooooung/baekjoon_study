import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] number;
        number = new int[num];
        int i=0;

        for(int i=0; i<num; i++){
            number[i] = sc.nextInt();
        }
        for(int i=0; i<num; i++){
            fibo(number[i]);
        }

    }

    static void fibo(int num){
        int result0=0, result1=1;
        int ppre0=1, ppre1=0;
        int pre0=0, pre1=1;
        if(num==0) {
            System.out.println("1 0");
            return ;
        }
        else if(num==1) {
            System.out.println("0 1");
            return ;
        }
        for(int i=1; i<num ; i++){
            result0 = ppre0+ pre0;
            result1 = ppre1+ pre1;
            ppre0 = pre0; pre0= result0;
            ppre1 = pre1; pre1 = result1;

        }
        System.out.println(result0+" "+result1);
        return ;
    }




}
