import java.util.Scanner;


public class Main {
    public static int[][] triangle = new int[501][501];
    public static int[][] dp = new int[501][501];
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];

                max = dp[i][j] > max ? dp[i][j] : max;
            }
        }

        if (n == 1) max = triangle[0][0];
        
        System.out.println(max);
    }

}


