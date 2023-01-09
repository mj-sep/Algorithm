import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isVisited = new boolean[26]; // 알파벳 중복 확인
    static int r; static int c;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int sol = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // int tcase = sc.nextInt();

        sol = 0;
        int j; int k;
        r = sc.nextInt(); c = sc.nextInt();

        map = new int[r][c];
        for (j=0; j<r; j++) {
            String str = sc.next();
            for (k = 0; k < c; k++) {
                map[j][k] = str.charAt(k) - 'A';
                // System.out.println("map( " + j + ", " + k + ")= " + map[j][k]);

            }
        }

        dfs(0,0,0);
        System.out.println(sol);
        
//        for(int i=0; i < tcase; i++){
//            sol = 0;
//            int j; int k;
//            r = sc.nextInt(); c = sc.nextInt();
//
//            map = new int[r][c];
//            for (j=0; j<r; j++) {
//                String str = sc.next();
//                for (k = 0; k < c; k++) {
//                    map[j][k] = str.charAt(k) - 'A';
//                    // System.out.println("map( " + j + ", " + k + ")= " + map[j][k]);
//
//                }
//            }
//
//            dfs(0,0,0);
//            System.out.println("#" + (i+1) + " " + sol);
//        }


    }

    public static boolean dfs(int x, int y, int cnt){
        if(isVisited[map[x][y]]) {
            sol = Math.max(sol, cnt);
            return true;
        } else {
            isVisited[map[x][y]] = true;
            for(int i=0; i<4; i++) {
                int ex = x + dx[i];
                int ey = y + dy[i];

                if(ex >= 0 && ex < r && ey >= 0 && ey < c){ // 범위 내부에 있다면
                    dfs(ex, ey, cnt+1); // 재귀
                }
            }

            isVisited[map[x][y]] = false;
            return true;
        }


    }


}