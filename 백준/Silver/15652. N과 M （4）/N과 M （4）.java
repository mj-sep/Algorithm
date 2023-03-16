import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    // 백트래킹 기초 - n과 m (4)
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder(); // 메모리 효율을 위해 sb 사용

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1부터 N까지의 자연수 중에서
        int m = sc.nextInt(); // M개를 고른 수열

        arr = new int[m];
        dfs(n, m, 0);
        System.out.println(sb);
    }

    public static void dfs(int n, int m, int depth){
        if (depth == m) {
            for (int array : arr) {
                sb.append(array).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<n; i++){
            if(depth == 0) {
                arr[depth] = i + 1;
                dfs(n, m, depth + 1);
            } else {
                arr[depth] = i + 1;
                if(arr[depth-1] <= arr[depth]) dfs(n, m, depth+1);
            }
        }

    }
}