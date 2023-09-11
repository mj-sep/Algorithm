import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static int[] array;
    public static Stack<Integer> stack = new Stack<>();
    public static Stack<Integer> temp = new Stack<>();
    public static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int idx = 1;
        int arrayIdx = 0;
        while (arrayIdx < n) {
            int peek = 0;
            if(!temp.isEmpty()) peek = temp.peek();

            if(idx > n + 1) {
                System.out.println("NO");
                return;
            }

            if (peek == array[arrayIdx]) {
                temp.pop();
                answer.add("-");
                stack.push(peek);
                arrayIdx++;
            } else {
                temp.push(idx);
                answer.add("+");
                idx++;
            }
        }
        
        for(String item: answer) {
            System.out.println(item);
        }
    }
}