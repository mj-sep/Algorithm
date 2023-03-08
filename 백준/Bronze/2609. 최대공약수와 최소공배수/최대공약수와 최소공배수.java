import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int max = 0;
        int gcd = 0; // 최대공약수
        int lcm = 0; // 최소공배수

        if(x>y) max = x;
        else max = y;

        // 최대공약수
        for(int i=1; i<=max; i++){
            if(x%i==0 && y%i==0) gcd = i;
        }

        // 최소공배수
        lcm = gcd * (x/gcd) * (y/gcd);
        System.out.println(gcd);
        System.out.println(lcm);
    }
}