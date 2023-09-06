import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] text = sc.next().split("-");
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < text.length; i++) {
            int temp = 0;
            String[] plus = text[i].split("\\+");
            for (int j = 0; j < plus.length; j++) {
                temp += Integer.parseInt(plus[j]);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else sum -= temp;
        }

        System.out.println(sum);
    }
}


