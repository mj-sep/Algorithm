import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // n보다 1 큰 배열을 만듦
        int[] arr = new int[n+1];
        arr[0]=0; arr[1]=0;

        for(int i=2; i<=n; i++) {
            arr[i] = arr[i-1] + 1; // arr[i]의 최소값은 arr[i-1]의 결과에 1을 더한 것
            // 3 또는 2의 배수라면 arr[i/3]+1까지의 최소값 구하기
            if(i % 3 == 0) arr[i] = Math.min(arr[i], arr[i/3] + 1);
            if(i % 2 == 0) arr[i] = Math.min(arr[i], arr[i/2] + 1);
        }
        System.out.println(arr[n]);
    }
}