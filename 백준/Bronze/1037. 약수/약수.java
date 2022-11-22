import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> divisor = new ArrayList<>();
        int answer = 0;

        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            divisor.add(sc.nextInt());
        }

        Collections.sort(divisor); // 오름차순으로 정렬 후
        if(divisor.size()<2) answer= (int) Math.pow(divisor.get(0), 2);
        else answer = divisor.get(0) * divisor.get(divisor.size()-1);
        System.out.println(answer);
    }
}