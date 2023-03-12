import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    // 백트래킹 알고리즘
    // 다 까묵었네.... 한참 걸림... 다시 공부 해야겠다
    public static int n;
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static int[] num; // 숫자 배열
    public static int[] sym = new int[4]; // 기호 배열 (+, -, *, / 순)
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        num = new int[n];
        
        // 숫자 입력 받기
        for(int i=0; i<n; i++){
            num[i] = sc.nextInt();
        }

        // 기호 입력 받기
        for(int i=0; i<4; i++){
            sym[i] = sc.nextInt();
        }

        dfs(num[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    public static void dfs (int number, int index) {

        if (index == n) {
            MAX = Math.max(MAX, number);
            MIN = Math.min(MIN, number);
            return;
        }

        for(int i=0; i<4; i++){
            if(sym[i] > 0) {
                sym[i]--;

                switch (i){
                    case 0: dfs(number + num[index], index+1); break;
                    case 1: dfs(number - num[index], index+1); break;
                    case 2: dfs(number * num[index], index+1); break;
                    case 3: dfs(number / num[index], index+1); break;
                }

                sym[i]++;
            }
        }
    }
}