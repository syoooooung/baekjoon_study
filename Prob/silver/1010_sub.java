// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;

public class Main {
    static int count=0;
    static int leftnum;
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
            int left, right;
            int num;
            int [] result;
            Scanner sc = new Scanner(System.in);
            num=sc.nextInt();
            result = new int[num];

            for(int k=0; k<num; k++){
                left = sc.nextInt();
                right = sc.nextInt();
                leftnum = left;

                int[] leftarr = null;
                int[] rightarr=null;
                leftarr = new int[left];
                rightarr = new int[right];

                for(int i=0; i< right; i++){
                    rightarr[i]=0;
                }
                //setloc call 할때마다 rightarr 0으로 초기화해
                setLoc(0, rightarr);

                result[k]=count;
                count=0;

            }
            for(int k=0; k<num ; k++){
                System.out.println(result[k]);
            }

    }

    static int setLoc(int order, int arr[]){   //arr은 right 임!
        if(order > arr.length){return 0;}

        int j = 0;
        for (; j < arr.length; j++) {
            if (arr[j] == 0) {
                break;
            }
        }
        if (j == arr.length) {
            return 0;
        }//시작할 위치를 못찾았어

        for(int i= j ; i< arr.length ; i++) {
            //order는 왼쪽에서의 내 위치야
            //내가 어디부터 시작할 수 있는지 찾아볼거야

            arr[i] = 1;

            if (order == leftnum - 1) { //왼쪽의 마지막이라면 count 올려주기
                arr[i]=0;
                count++;
            } else {
                order++;
                setLoc(order, arr);
                order--;
            }
        }

        for(int k=j ; k<arr.length ; k++){
            arr[k]=0; //반복을 위해 0으로 초기화
        }
        return 1;
    }
}
