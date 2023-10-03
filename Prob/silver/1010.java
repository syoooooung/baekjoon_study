import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            int left, right;
            int num;
            int [] result;
            Scanner sc = new Scanner(System.in);
            num=sc.nextInt();
            result = new int[num];

            for(int k=0; k<num; k++){
                left = sc.nextInt();
                right = sc.nextInt();

                int count =1;
                for(int j=0; j<left ; j++){
                    count *= (right-j);
                    count /= (j+1);
                }
                result[k]=count;
                count=0;

            }
            for(int k=0; k<num ; k++){
                System.out.println(result[k]);
            }
    }
}
