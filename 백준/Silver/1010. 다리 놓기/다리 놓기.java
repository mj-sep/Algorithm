import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void dp(int m, int n, long k) {
        BigInteger result = new BigInteger("1");
        for (int i = m; i >= k; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        BigInteger div = new BigInteger("1");
        for (int j = n; j >= 1; j--) {
            div = div.multiply(BigInteger.valueOf(j));
        }
        
        BigInteger answer = result.divide(div);
        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long k = m - n + 1;
            dp(m, n, k);
        }
    }
}