import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            list.clear();
            for(int j=0; j<10; j++){
                list.add(sc.nextInt());
            }
            Collections.sort(list);
            System.out.println(list.get(7));
        }
    }
}