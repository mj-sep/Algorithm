import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;


public class Main {
    // 14889 스타트와 링크
    // 삽질 1) 팀 값 받을 때 start = arr[i] + arr[j];로 받았더니 start 팀이 누적되지 않아서 틀린 값이 나왔었음...(!!)
    // 삽질 2) 시간 초과 뜸... -> Scanner에서 BufferedReader로 입력 방법을 변경 -> 엥 근데 왜 또 시간 초과..(?)
    // 삽질 2-해결) team 재귀 호출 부분에서 i+1이 아닌 idx+1을 하고 있었음... 해결 완
    
    public static int[][] arr;
    public static boolean[] visited;
    public static int N;
    public static int minimum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // N = sc.nextInt();

        arr = new int[N][N];
        visited = new boolean[N];

        /*
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
         */

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        team(0, 0);
        System.out.println(minimum);
    }

    public static void team(int n, int depth) {
        // 스타트팀과 링크팀 구분하기
        // 팀원이 반으로 나뉘었다면 차이 구하고 리턴
        if (depth == N / 2) {
            diff();
            return;
        }

        // 아직 방문하지 않은 노드이면
        for (int i = n; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true; // visited 배열 true 변경하고
                team(i + 1, depth + 1); // 재귀
                visited[i] = false; // 재귀 끝나면 다시 visited false로
            }
        }
    }

    public static void diff() {
        int start = 0;
        int link = 0;
        int diffe = Integer.MAX_VALUE;

        // visited true인 경우 start, false인 경우 link
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] == true && visited[j] == true) {
                    // 삽질 파트 (^_ㅠ)
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (visited[i] == false && visited[j] == false) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        diffe = Math.abs(start - link);

        // System.out.println("start: " + start + ", link: " + link + ", diffe: " + diffe);

        if (diffe == 0) {
            System.out.println(diffe);
            System.exit(0);
        }
        minimum = Math.min(diffe, minimum);
    }

}