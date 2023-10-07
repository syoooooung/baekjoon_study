import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long[] arr;
        arr= new long[10];
        for(int i=0; i<10; i++)
            arr[i]=0;
        Scanner sc = new Scanner(System.in);
        long number =  sc.nextInt();
        int Isfir =0;
        int digit = (int) (Math.log10(number))+1;

        if(number>9)
            arr[0]++;
        
        //그 수에서 10을 나눈 몫으로 몇번째 자릿수인지 판별
        while(true) {
            digit-=1;
            if(digit<=0){break;}
            
            int tmp = (int) (number / Math.pow(10, digit)); //제일 왼쪽 수가 몇인지판단
            long ten = (long) (Math.pow(10, digit) * tmp); //X000.. 으로 맞추기
            number -= ten;  //다음 수
            arr[tmp]+=(number+1);
            
            long plusnum = neednum(digit);

            for(int i=0; i<10 ; i++){
                if(i>=tmp && i!=0){
                    arr[i]+= (plusnum* (tmp)) ;
                }
                else if(i==0){
                    if(Isfir==0) {
                        arr[i] += (plusnum * (tmp - 1));
                    }
                    else{
                        arr[i]+= (plusnum* (9)) ;
                        
                        if(tmp !=0)
                            arr[i]+= Math.pow(10, digit); //그냥 pow 넣고 얘를 뺄가
                        arr[i]+= (plusnum* (tmp));

                    }
                }
                else{
                    arr[i]+= Math.pow(10, digit); //그냥 pow 넣고
                    arr[i]+= (plusnum* (tmp)) ;
                }
            }
            Isfir=1;
            pre_digit= digit;
            //if(number ==0)
            //    break;
        }


        for(int i=1; i<number+1 ; i++){
            arr[i]++;
        }

        for(int i=0; i<10; i++)
            System.out.print(arr[i]+" ");
    }

    static long neednum(int digit){ //7XXX를 위해 함수호출했자면 digit은 3. XXX에 사용되는 각 숫자의 수
        long result=1;
        if(digit==1 )
            return 1;
        result = (long) (digit*Math.pow(10, digit-1));
        return result;
    }


}
