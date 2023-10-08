import java.util.Scanner;
import java.util.Stack; //import
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String[] result;
        result = new String[num];

        for(int i=0; i<num; i++){
            int IsFal = 0;
            Stack<Integer> st = new Stack<>();
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            for(int j=0; j< arr.length ; j++){
                if(arr[j]=='(')
                    st.push(j);
                else{
                    if(st.empty()){
                        IsFal=1;
                        break;
                    }
                    else{
                        st.pop();
                    }

                }
            }
            if(!st.empty())
                IsFal=1;
            if(IsFal ==0)
                result[i]="YES";
            else
                result[i]="NO";
            
        }
        for(int i=0; i<num;i++){
            System.out.println(result[i]);
        }

    }


}
