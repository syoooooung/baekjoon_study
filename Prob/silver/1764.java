import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numL=0, numS=0;
        numL = sc.nextInt();
        String[] not_listen= new String[numL];
        numS = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        for(int i=0; i<numL; i++) {
            String st = sc.nextLine();
            map.put(st, 1);
        }
        int k=0;
        for(int i=0; i<numS ; i++){
            String tmp = sc.nextLine();
            if(map.containsKey(tmp)){
                map2.put(tmp,1);
                k++;
            }
        }
        System.out.println(k);
        List<String> key = new ArrayList<>(map2.keySet());
        Collections.sort(key);
        for(String keyy : key)
            System.out.println(keyy);
    }
}
