import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static int vertex, edge, start;
    static boolean[] visited;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new int[vertex+1][vertex+1];
        visited = new boolean[vertex+1];
        for(int i=0; i< edge ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = graph[to][from]= 1;
        }
        dfs(start);
        sb.append("\n");
        visited = new boolean[vertex+1];
        bfs(start);
        System.out.println(sb);
    }

    public static void dfs(int start){
        visited[start]=true;
        sb.append(start+" ");
        for(int i=0; i<= vertex ; i++){
            if(graph[start][i] == 1 && !visited[i])
                dfs(i);
        }
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            start = q.poll();
            sb.append(start +" ");
            for(int i=1; i<=vertex ; i++){
                if(graph[start][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
}
