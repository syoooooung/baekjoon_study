import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int entry_num = Integer.parseInt(br.readLine());
        ArrayList<Prob> prob_list = new ArrayList<Prob>();
        for(int i=0; i<entry_num ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cup_noodle = Integer.parseInt(st.nextToken());
            Prob tmp = new Prob(deadline, cup_noodle);
            prob_list.add(tmp);
        }
        Collections.sort(prob_list);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(Prob pr : prob_list){
            if(q.size()< pr.deadline){ //queuesize 보다 deadline이 크면
                q.add(pr.cup_noodle); //queue에 넣음
                continue;
            }
            if(q.peek() < pr.cup_noodle){ //queue의 front보다 컵라면 수가 많다면
                q.poll(); //front를 pop하고
                q.add(pr.cup_noodle); //queue에 push
            }

        }
        long result =0;
        while(!q.isEmpty()){
            result += q.poll();
        }
        System.out.println(result);

    }

}

class Prob implements Comparable<Prob>{
    int deadline;
    int cup_noodle;
    public Prob(int deadline, int cup_noodle){
        this.deadline = deadline;
        this.cup_noodle = cup_noodle;
    }
    public int compareTo(Prob o){ //this가 더 크면 양수반환, o가 더 크면 음수 반환

        if(this.deadline == o.deadline){ //dead_line 이 같다면
            return this.cup_noodle - o.cup_noodle ; //컵라면 수로 정렬
        }
        else{ //마감기한이 다르다.
            return this.deadline - o.deadline; // deadline으로 정렬
        }
    }
}
