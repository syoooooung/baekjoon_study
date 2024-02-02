import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static int Min = Integer.MAX_VALUE;
    static int[][] V;
    static boolean[] visited;
    static int n;
    static int start_num=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        V = new int[n][n];
        visited = new boolean[n];
        for(int i=0; i<n ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0; j<n; j++){
                V[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        maxV(0);
        System.out.println(Min);
        bf.close();
    }
    static void maxV(int idx){ //idx는 index로 하겠다.
        if(start_num==n/2){ //이거 idx-1할지 다시 보기
            Min = Math.min(Min, total_V());
            return;
        }

        for(int i=idx ; i<n; i++){
            if(!visited[i]){
                visited[i]=true;
                start_num++;
                maxV(i+1);
                visited[i]=false;
                start_num--;
            }
        }
    }
    static int total_V(){
        int start=0, link=0;
        for(int i=0; i<n; i++){
            for(int j=0 ;j<n ; j++){
                if(visited[i]==true && visited[j]==true){
                    start+=V[i][j];
                }
                else if (visited[i]==false && visited[j]==false){
                    link+=V[i][j];
                }
            }
        }
        if(start>link){
            start = start-link;
        }
        else{
            start = link-start;
        }
        return start;
    }

}
