import javax.xml.catalog.CatalogFeatures;
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        // DP 점화식 세우기
        /*
        0 -> 0가지, 1 -> 1가지(1), 2 -> 2가지(1+1, 2), 3 -> 4가지(1+1+1, 2+1, 1+2, 3),
        4 -> 7가지(1+1+1+1, 1+3, 3+1, 2+2, 1+2+1, 2+1+1, 1+1+2)
        DP[i] = DP[i-1] + DP[i-2] + DP[i-3]
         */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스의 개수

        int[] dp = new int[12];
        dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 4;

       for(int i=4; i<11; i++){
           dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
       }

       for(int j=0; j<t; j++){
           int n = sc.nextInt();
           System.out.println(dp[n]);
       }
    }
}