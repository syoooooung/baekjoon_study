import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static int vertex;
    static int[][] map;
    static int[][] visited;
    static int dx[]={0,0,1,-1};
    static int dy[]={-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        vertex = Integer.parseInt(bf.readLine());
        map=new int[vertex][vertex];
        visited =new int[vertex][vertex];

        for(int i=0; i<vertex; i++){
            String st = bf.readLine();
            for(int j=0; j<vertex ; j++){
                map[i][j]= st.charAt(j)-'0';
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<vertex; i++){
            for(int j=0; j<vertex ; j++){
                if(map[i][j]==1 && visited[i][j]==0){
                    int num = bfs(i,j);
                    pq.add(num);
                }
            }
        }
        System.out.println(pq.size());
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
        bf.close();
    }
    static int bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        int num=1;
        q.add(new int[]{i,j});
        visited[i][j]= 1;
        while(!q.isEmpty()){
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();
            for(int k=0; k<4; k++){
                int nx = cx+dx[k];
                int ny = cy+dy[k];
                if(nx>=0 && ny>=0 && nx< vertex && ny<vertex ){
                    if(visited[nx][ny]==0 && map[nx][ny]==1){
                        visited[nx][ny]=1;
                        num++;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return num;
    }

}
