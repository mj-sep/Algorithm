import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> height = new ArrayList<>(); // 키
        ArrayList<Integer> weight = new ArrayList<>(); // 몸무게

        int p_num = sc.nextInt();
        for(int i=0; i<p_num; i++){
            weight.add(sc.nextInt());
            height.add(sc.nextInt());
        }

        int score = 0;
        for(int i=0; i<p_num; i++){
            score = 0;
            for(int j=0; j<p_num; j++){
                if(weight.get(i) < weight.get(j) && height.get(i) < height.get(j)) score++;
            }
            System.out.printf(score+1 + " ");
        }


    }
}