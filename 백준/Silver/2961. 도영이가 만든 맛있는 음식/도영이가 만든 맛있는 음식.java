import java.io.*;
import java.util.*;

public class Main {
    static int num; // 재료의 개수
    static int[] sour;
    static int[] bitter;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();
        sour = new int[num];
        bitter = new int[num];

        for(int i=0; i<num; i++){
            sour[i] = sc.nextInt();
            bitter[i] = sc.nextInt();
        }

        System.out.println(subset(0,1,0));
  }

    public static int subset (int cnt, int psour, int pbitter) {
        if (cnt == num) {
            // 공집합인 경우 int 최대값 리턴 (최솟값으로 추출되지 못하게)
            if (psour == 1 && pbitter == 0)
                return Integer.MAX_VALUE;
            return Math.abs(psour-pbitter);
        }

        int a = subset(cnt+1, psour*sour[cnt], pbitter+bitter[cnt]);
        int b = subset(cnt+1, psour, pbitter);
        return Math.min(a,b);
    }
    
    
}