import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Integer> quit = new ArrayList<>(); // 내린 사람 수
        List<Integer> board = new ArrayList<>(); // 탄 사람 수
        int[] pass = new int[10]; // 현재 승객 수


        for(int i=0; i<10; i++){
            quit.add(sc.nextInt());
            board.add(sc.nextInt());
            pass[i] = 0;
        }

        pass[0] = board.get(0);
        int max = pass[0];

        for(int i=1; i<10; i++){
            pass[i] = pass[i-1] - quit.get(i) + board.get(i);
            if(pass[i] > max) max = pass[i];
        }

        System.out.println(max);
    }
}