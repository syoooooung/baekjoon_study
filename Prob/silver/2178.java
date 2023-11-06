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
    static int [][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        //row가 줄 수
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        maze= new int[row][col];
        visited = new int[row][col];
        for(int i=0; i<row ; i++){
            String s = bf.readLine();
            for(int j=0; j<col ; j++){
                maze[i][j]= s.charAt(j) - '0';
            }
        }
        visited[0][0]=1;
        bfs(0,0);
        System.out.println(maze[row-1][col-1]);
    }

    public static void bfs(int x, int y){
        Queue<int[] >q = new LinkedList<>();
        q.add(new int[] {x,y});
        while(!q.isEmpty()){
            int now[] = q.poll();
            int nowX= now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY+ dy[i];

                if(nextX< 0 || nextY<0 || nextX >= row || nextY>= col)
                    continue;
                if(visited[nextX][nextY]==1 || maze[nextX][nextY] == 0)
                    continue;
                q.add(new int[] {nextX, nextY});
                maze[nextX][nextY] = maze[nowX][nowY]+1;
                visited[nextX][nextY]= 1;

            }
        }
    }
}
