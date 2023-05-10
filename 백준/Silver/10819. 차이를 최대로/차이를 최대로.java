import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int result = Integer.MIN_VALUE;
    static boolean[] isVisted;
    static String[] arr;
    static int[] selected;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // List<String> list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");
        isVisted = new boolean[N];
        selected = new int[N];

        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int cnt) {
        if (cnt == N) {
            result = Math.max(getResult(), result);
            return;
        }
        for (int i=0; i<N; i++) {
            if(!isVisted[i]) {
                isVisted[i] = true;
                selected[cnt] = Integer.parseInt(arr[i]);
                dfs(cnt+1);
                isVisted[i] = false;
            }
        }
    }

    public static int getResult() {
        int sum = 0;
        for(int i=0; i<N-1; i++) {
            sum += Math.abs(selected[i] - selected[i+1]);
        }
        return sum;
    }
}