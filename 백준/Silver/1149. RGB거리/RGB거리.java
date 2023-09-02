import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static int[][] cost = new int[1001][3];
    public static int[][] d = new int[1001][3];
    public static int min = Integer.MAX_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        d[0][0] = cost[0][0];
        d[0][1] = cost[0][1];
        d[0][2] = cost[0][2];

        for (int i = 1; i < N; i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + cost[i][0];
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + cost[i][1];
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + cost[i][2];
        }

        min = Math.min(d[N - 1][1], d[N - 1][2]);
        System.out.println(Math.min(d[N - 1][0], min));
    }

}


