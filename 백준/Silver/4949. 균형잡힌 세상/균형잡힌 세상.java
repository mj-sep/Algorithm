import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Stack<String> stack = new Stack<>();

    public static boolean determine(String[] input) {
        stack.clear();
        for(String item: input) {
            if(item.equals("(") || item.equals("[")) {
                stack.push(item);
            } else if (item.equals(")") || item.equals("]")) {
                String peek = "";
                if(!stack.isEmpty()) peek = stack.peek();
                if(item.equals(")") && peek.equals("(")) {
                    stack.pop();
                } else if (item.equals("]") && peek.equals("[")) {
                    stack.pop();
                } else return false;
            } else {

            }
        }
        if(!stack.isEmpty()) return false;
        else return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isFinish = false;
        while(!isFinish) {
            String[] input = sc.nextLine().split("");
            if(input.length == 1 && input[0].equals(".")) {
                break;
            }
            String type = determine(input) ? "yes" : "no";
            System.out.println(type);
        }
    }
}