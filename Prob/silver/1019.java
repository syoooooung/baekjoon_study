import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr;
        arr= new int[10];
        for(int i=0; i<10; i++)
            arr[i]=0;
        Scanner sc = new Scanner(System.in);
        int number =  sc.nextInt();
        int Isfir = 0;
        //그 수에서 10을 나눈 몫으로 몇번째 자릿수인지 판별

        while(true) {
            int digit = (int) (Math.log10(number));
            if(digit<0){break;}
            int tmp = (int) (number / Math.pow(10, digit)); //제일 왼쪽 수가 몇인지판단
            number -= Math.pow(10, digit) * tmp;
            arr[tmp]+=(number+1);
            if(Isfir != 0) {
                for (int i = 0; i < 10; i++) {
                    arr[i] += neednum(digit+1); //여기에 tmp인 경우 제외해야하지않나
                }
            }
            else{
                for (int i = 1; i < tmp; i++) {
                    arr[i] += neednum(digit+1);
                }
                Isfir=1;
            }
        }
        for(int i=1; i<number+1 ; i++){
            arr[i]++;
        }

        for(int i=0; i<10; i++)
            System.out.print(arr[i]+" ");

    }

    static int neednum(int digit){
        int result=0;
        for(int i=0; i<digit ; i++)
            result += Math.pow(10,i);
        return result;
    }

}
