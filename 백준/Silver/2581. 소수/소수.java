import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // 2는 소수이므로 m이 2 이하일 경우에는 3부터 입력받고 2는 소수로 선처리.
        // -> 했더니 1 1이 input인 경우에 오류 발생
        // 해결 : for문 사이에 조건문을 넣어 둘다 input 1인 경우에는 break

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean check = true;
        int sum = 0;

        List<Integer> list = new ArrayList<>();


        if (m<3 && n!=1) {
            list.add(2);
            m=3;
        }

        for (int i = m; i <= n; i++) {
            if(m == 1 && n == 1) break;
            check = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    // 소수 아님
                    check = false;
                }
            }
            if (check == true) list.add(i);
        }


        for(int i=0; i<list.size(); i++){
            sum += list.get(i);
        }

        Collections.sort(list);

        if(list.size() >= 1) {
            System.out.println(sum);
            System.out.println(list.get(0));
        } else System.out.println("-1");
    }
}