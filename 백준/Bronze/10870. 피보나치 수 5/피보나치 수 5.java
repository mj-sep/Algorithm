import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fibonacci(n));

    }
    static int fibonacci(int n) {
        if (n == 0)	return 0;
        if (n == 1)	return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
}