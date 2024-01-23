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

    static int[][] mat;
    static int n;
    public static void main(String[] args) throws IOException{
       BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(bf.readLine());

       n = Integer.parseInt(st.nextToken());
       long pow = Long.parseLong(st.nextToken());
       mat = new int[n][n];

       for(int i=0; i<n ;i++){
           st = new StringTokenizer(bf.readLine());
           for(int j=0; j<n ; j++){
               mat[i][j] = Integer.parseInt(st.nextToken())%1000 ;
           }
       }

       int[][] result = merge( pow);
       for(int i=0; i<n ; i++){
           for(int j=0; j<n; j++){
               System.out.print(result[i][j]+" ");
           }
           System.out.print("\n");
       }
       bf.close();
    }

    static int[][] merge(long exp){
        if(exp == 1){
            return mat;
        }

        int[][] A = merge(exp/2);

        A= mult(A,A);

        if(exp%2 == 1){ //만약 홀수라면
            A=mult(A,mat);
        }
        return A;
    }
    static int[][] mult(int[][]A, int[][]B){
        int[][] result=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n ; k++){
                    result[i][j] += A[i][k]* B[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }

}
