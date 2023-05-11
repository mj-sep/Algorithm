import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long finalSum = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 약수로 푸는 접근 방법은 시간 초과 발생 -> 배수로 접근하기
        for(int i=1; i<=n; i++) {
            finalSum += i * (n/i);
        }

        System.out.println(finalSum);
    }

}