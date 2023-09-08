import java.math.BigInteger;
import java.util.*;

public class Main {

    public static LinkedList<Integer>[] list;
    public static boolean[] visited;
    public static int cnt = 1;

    public static void bfs(int start) {
        visited[start] = true;
        for (int item : list[start]) {
            if (visited[item] == false) {
                visited[item] = true;
                bfs(item);
            }
        }
    }

    // 모든 노드를 방문했는지 판별
    public static boolean isAllTrue(boolean[] arr) {
        for (boolean b : arr) {
            if (!b) return false;
        }
        return true;
    }

    // 미방문 노드의 최소값
    public static int minimumIndex(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == false) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        list = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        visited[0] = true;

        for (int i = 0; i < N + 1; i++) {
            list[i] = new LinkedList();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list[u].add(v);
            list[v].add(u);
        }

        bfs(1);
        while (!isAllTrue(visited)) {
            bfs(minimumIndex(visited));
            cnt++;
        }

        System.out.println(cnt);
    }
}