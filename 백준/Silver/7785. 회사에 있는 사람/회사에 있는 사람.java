import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static HashMap<String, String> map = new HashMap<>();
    static List<String> notLeave = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<N; i++) {
            String input1 = sc.next();
            String input2 = sc.next();
            map.put(input1, input2);
        }

        // value = enter인 key만 뽑아서 notLeave 리스트에 삽입
        for(String key: map.keySet()) {
            if(map.get(key).equals("enter")) notLeave.add(key);
        }

        Collections.sort(notLeave, Collections.reverseOrder());
        for(String item: notLeave) {
            System.out.println(item);
        }
    }
}