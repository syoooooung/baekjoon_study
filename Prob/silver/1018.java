import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static boolean[][] chess;
    static int min=64;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        chess = new boolean[n][m];

        for(int i=0; i<n ; i++){
            String str = bf.readLine();
            for(int j=0; j<m; j++){
                if(str.charAt(j)=='W'){ //white는 true
                    chess[i][j]=true;
                }
                else{ //black은 false로 저장
                    chess[i][j]=false;
                }
            }
        }

        for(int i=0; i<n-7 ; i++){
            for(int j=0; j<m-7 ; j++){
                brute_force(i,j);
            }
        }
        System.out.println(min);
    }

    static void brute_force(int x, int y){
        int cnt=0;
        boolean WB = chess[x][y]; //첫 번째 색 저장

        for(int i=x; i<x+8 ; i++){
            for(int j=y; j<y+8; j++){
                if(chess[i][j] != WB){
                    cnt++;
                }
                WB = !WB;
            }
            WB = !WB;
        }

        cnt=Math.min(cnt, 64-cnt);
        min = Math.min(min,cnt);
    }

}
