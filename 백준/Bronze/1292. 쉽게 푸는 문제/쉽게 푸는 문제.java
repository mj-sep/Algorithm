import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        int sum=0;

        for(int i=0; i<1000; i++){
            for(int j=0; j<=i; j++){
                list.add(i+1);
            }
        }

        for(int i=x-1; i<=y-1; i++){
            sum += list.get(i);
        }

        System.out.println(sum);
        // 으음... 코드가 뭔가 비효율적인 것 같음....
    }
}