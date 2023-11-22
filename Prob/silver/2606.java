import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static boolean[] visited;
    static boolean[][] maze;
    static int vertex;
    static int edge;
    static int result=0;
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        visited = new boolean[vertex+1];
        maze = new boolean[vertex+1][vertex+1];
        
        for(int i=0; i<edge; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            maze[from][to] = maze[to][from] = true;
        }
        dfs(1);
        System.out.println(result-1);
    }
    static void dfs(int current){
        visited[current]=true;
        result++;
        for(int i=0; i<=vertex ; i++){
            if(maze[current][i] && !visited[i])
                dfs(i);
        }
    }
}
