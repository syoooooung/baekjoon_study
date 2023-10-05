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
            if(digit<=0){break;}
            int tmp = (int) (number / Math.pow(10, digit)); //제일 왼쪽 수가 몇인지판단
            int ten = (int) (Math.pow(10, digit) * tmp); //X000.. 으로 맞추기
            number -= ten;  //다음 수
            arr[tmp]+=(number+1);
            int plusnum = neednum(digit);

            for(int i=0; i<10 ; i++){
                if(i>=tmp || i==0){
                    arr[i]+= (plusnum* (tmp-1)) ;
                }
                else{
                    arr[i]+= Math.pow(10, digit); //그냥 pow 넣고
                    arr[i]+= (plusnum* (tmp-1)) ;
                }
            }
        }
        for(int i=1; i<number+1 ; i++){
            arr[i]++;
        }

        for(int i=0; i<10; i++)
            System.out.print(arr[i]+" ");
    }

    static int neednum(int digit){ //7XXX를 위해 함수호출했자면 digit은 3. XXX에 사용되는 각 숫자의 수
        int result=1;
        if(digit==1 )
            return 1;
        result=20;
        for(int i=2; i<digit ; i++) {
            result = (int) (Math.pow(10, i-1) + 9 * result);
        }
        return result;
    }

    static void cal10(int num, int tmp, int arr[], int digit){
        int result=0;
        for(int i=0; i<10 ; i++){
            if(i>=tmp || i==0){
                arr[i]+= (neednum(digit)* (tmp-1)) ;
            }
            else{
                arr[i]+= Math.pow(10, digit); //그냥 pow 넣고
                arr[i]+= (neednum(digit)* (tmp-1)) ;
            }
        }
    }

}
