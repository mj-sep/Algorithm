import java.util.Scanner;

public class Main {

    public static long[][] stuff = new long[101][2];
    public static long[][] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 물건의 수
        long k = sc.nextLong(); // 최대 무게

        for (int i = 1; i < n + 1; i++) {
            stuff[i][0] = sc.nextInt(); // 각 물건의 무게 W
            stuff[i][1] = sc.nextLong(); // 해당 물건의 가치 V
        }

        dp = new long[n + 1][(int) (k + 1)];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - stuff[i][0] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][(int) (j - stuff[i][0])] + stuff[i][1]); // 더 큰 값으로 갱신
                }
            }
        }

        System.out.println(dp[n][(int) k]);

    }
}