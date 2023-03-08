import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 브루트포스
        Scanner sc = new Scanner(System.in);
        int[] nan = new int[9];
        int sum = 0;

        for(int i=0; i<9; i++){
            nan[i] = sc.nextInt();
            sum += nan[i];
        }

        int result = sum - 100;
        int check1 = 0; int check2 = 0;

        // 두 수의 합이 result이면 해당하는 두 수는 제외되는 수
        for(int i=0; i<9; i++){
            for(int j=1; j<9; j++){
                if(nan[i] + nan[j] == result) {
                    check1 = i; check2 = j;
                    break;
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<9; i++){
            if(i!=check1 && i!=check2) answer.add(nan[i]);
        }

        Collections.sort(answer);

        for(int i=0; i<7; i++){
            System.out.println(answer.get(i));
        }
    }


}