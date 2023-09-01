import java.util.Scanner;

public class Main {

    public static int[] d = new int[1001];

    public static int dp(int x) {
        if (x == 1) return 1;
        if (x == 2) return 2;
        if (d[x] != 0) return d[x];
        return d[x] = (dp(x - 1) + dp(x - 2)) % 10007;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(dp(n));
    }
}
