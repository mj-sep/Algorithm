import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수의 개수 N
        int m = sc.nextInt(); // 합을 구해야 하는 횟수 M

        int[] section = new int[n];
        int n1 = 0; int n2 = 0; // i, j번째 수
        int sum = 0; int total_sum = 0;
        int[] psum = new int[n]; // 누적 합

        for (int i = 0; i < n; i++) {
            section[i] = sc.nextInt();
            sum += section[i];
            psum[i] = sum;
        }

        // System.out.println(Arrays.toString(psum));
        for (int i = 0; i < m; i++) {
            n1 = sc.nextInt()-1;
            n2 = sc.nextInt()-1;
            if(n1 != 0) total_sum = psum[n2] - psum[n1-1];
            else total_sum = psum[n2];
            System.out.println(total_sum);
        }

        /*
        시도 1 : 이중 for문 방식으로 section 값과 구할 구간을 각각 입력받고
        다시 for문을 이용해서 section 값의 부분 구간을 구하는 방법 -> 시간 초과
         */
        /*
        시도 2 : 처음에 section 값을 입력 받으면서 아예 누적합도 입력 받는 방법
         */
    }
}