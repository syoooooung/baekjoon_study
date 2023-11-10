import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static int [][] maze;
    static int row=0, col=0;
    static boolean [] visited = new boolean[26];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int max=0;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        //row가 줄 수
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        maze= new int[row][col];

        for(int i=0; i<row ; i++){
            String s = bf.readLine();
            for(int j=0; j<col ; j++){
                maze[i][j]= s.charAt(j) - 'A';
            }
        }
        //visited[0][0]=1;
        dfs(0,0,1);
        System.out.println(max);
    }

    public static void dfs(int x, int y, int cnt){
        visited[maze[x][y]]=true;
        max = Math.max(max, cnt);

        visited[maze[x][y]] = true;
        for(int i=0 ; i<4 ; i++){
            int new_x = x+dx[i];
            int new_y = y + dy[i];
            if(new_x >= 0 && new_y>= 0 && new_x<row && new_y< col && visited[maze[new_x][new_y]]==false) {
                dfs(new_x, new_y, cnt + 1);
                visited[maze[new_x][new_y]] = false;
            }
        }
    }
}
