import java.math.BigInteger;
import java.util.*;

public class Main {
    // 2504 괄호의 값

    public static Stack<Character> stack = new Stack<>();
    public static int sum = 0;
    public static int multiple = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '[':
                    stack.push('[');
                    multiple *= 3;
                    break;
                case '(':
                    stack.push('(');
                    multiple *= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        System.out.println(0);
                        return;
                    }

                    if (str.charAt(i - 1) == '[') sum += multiple;
                    stack.pop();
                    multiple /= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        System.out.println(0);
                        return;
                    }

                    if (str.charAt(i - 1) == '(') sum += multiple;
                    stack.pop();
                    multiple /= 2;
                    break;
            }
        }

        System.out.println(!stack.isEmpty() ? 0 : sum);
    }
}