import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    
    // 백트래킹 기초
    // 어제 푼 거랑 아주 유사함
    
    public static int arr[];
    public static boolean visit[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1부터 n까지의 자연수 중에서
        int m = sc.nextInt(); // 중복 없이 M개를 고른 수열

       arr = new int[m];
       visit = new boolean[n];

       dfs(n, m, 0);
       System.out.println(sb);
    }

    public static void dfs(int n, int m, int depth){
        if(depth == m) {
            for(int array: arr){
                sb.append(array).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<n; i++){
            if(!visit[i]) {
                visit[i] = true;
                if(depth == 0) {
                    arr[depth] = i + 1;
                    dfs(n, m, depth + 1);
                } else if(depth > 0) { 
                    arr[depth] = i + 1;
                    // 앞 인덱스의 값보다 큰 값이어야만 함.
                    if(arr[depth-1] < arr[depth]) dfs(n, m, depth + 1);
                }
                visit[i] = false;
            }
        }
    }
}