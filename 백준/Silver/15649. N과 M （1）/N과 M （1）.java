import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    
    // 백트래킹 알고리즘 - 기초
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visit; // 방문 여부 확인
    public static int[] array; 

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1부터 n까지
        int m = sc.nextInt(); // 중복 없이 m개를 고른 수열

        array = new int[m]; // m개 고른 수열
        visit = new boolean[n]; // 1부터 n까지 방문 여부

        sol(n, m, 0);
        System.out.println(sb);
    }

    public static void sol(int n, int m, int dep){
        if(dep == m) { // 모든 수를 골랐다면 출력 (StringBuilder)
            for(int val: array) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i=0; i<n; i++) {
            if(visit[i] != true) { // 방문 여부 확인 (아직 방문하지 않은 노드이면)
                visit[i] = true; // visit을 true로 바꿔주고
                array[dep] = i+1; // array 배열에 숫자(i) 추가하고
                sol(n, m, dep+1); // 다음 깊이(인덱스)로 이동하여 탐색
                visit[i] = false; // 방문한 노드는 다시 false로 바꿔줌
            }
        }
    }
}