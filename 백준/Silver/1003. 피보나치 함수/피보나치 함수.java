import java.util.Scanner;

public class Main {
    public static int dx[][] = new int[41][2];

    public static int dpZero(int x) {
        if (x == 0) {
            return 1;
        }
        if (x == 1) {
            return 0;
        }
        if (dx[x][0] != 0) return dx[x][0];

        return dx[x][0] = dpZero(x - 1) + dpZero(x - 2);
    }

    public static int dpOne(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (dx[x][1] != 0) return dx[x][1];

        return dx[x][1] = dpOne(x - 1) + dpOne(x - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            System.out.println(dpZero(n) + " " + dpOne(n));
        }

    }
}


