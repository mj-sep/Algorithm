import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // 백트래킹 기초 - n와 m 문제들과 유사
    // 같은 수를 여러 번 골라도 됨
    public static StringBuilder sb = new StringBuilder();
    public static int arr[];
    public static boolean visit[];

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1부터 n까지 자연수 중에서
        int m = sc.nextInt(); // m개를 고른 수열

        arr = new int[m];
        visit = new boolean[n];

        dfs(n, m, 0);
        System.out.println(sb);
    }

    public static void dfs(int n, int m, int depth){
        if(depth == m){
            for(int array: arr){
                sb.append(array).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<n; i++){
            arr[depth] = i+1;
            dfs(n, m, depth+1);
        }
    }
}