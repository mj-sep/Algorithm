import java.util.Scanner;

public class Main {
    public static long[] d = new long[101];

    public static long dp(int x) {
        if (x > -1 && x < 3) return 1;
        if (d[x] != 0) return d[x];
        return d[x] = dp(x - 3) + dp(x - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            System.out.println(dp(n - 1));
        }
    }
}