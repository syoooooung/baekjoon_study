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

    public static void main(String[] args) throws IOException{
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();

       int n = Integer.parseInt(bf.readLine());
       PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //제일 작은게 우선 순위
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)-> o2-o1); //제일 큰게 우선순위

       for(int i=0; i<n ; i++){
           int num = Integer.parseInt(bf.readLine());
           if(minHeap.size() != maxHeap.size()){ //최대힙과 최소힙의 사이즈가 다를 경우
               if(maxHeap.peek()> num){
                   int swap_tmp = maxHeap.poll();
                   maxHeap.add(num);
                   minHeap.add(swap_tmp);
               }
               else{
                   minHeap.add(num);
               }
           }
           else{ //최대힙과 최소힙의 사이즈가 같은 결우
               if(maxHeap.isEmpty()){ //첫 입력은 maxheap에 넣어준다.
                   maxHeap.add(num);
               }
               else if(minHeap.peek()< num){
                   int swap_tmp = minHeap.poll();
                   minHeap.add(num);
                   maxHeap.add(swap_tmp);
               }
               else{
                   maxHeap.add(num);
               }
           }
           sb.append(maxHeap.peek()+"\n");
       }
       System.out.print(sb);
       bf.close();
    }

}
