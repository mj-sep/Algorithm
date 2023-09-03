import java.util.Scanner;

public class Main {
    public static int[] num;
    public static int[] dp;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        num = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        dp[0] = num[0];
        max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
            max = dp[i] > max ? dp[i] : max;
        }

        if (n == 1) max = num[0];
        System.out.println(max);
    }
}