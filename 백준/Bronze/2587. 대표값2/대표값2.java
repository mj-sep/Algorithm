import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferReader로 입력 받아야 시간 단축
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> numlist = new ArrayList<>();

        String str="";

        int sum=0;
        for(int i=0; i<5; i++){
            str=br.readLine();
            numlist.add(Integer.parseInt(str));
            sum += Integer.parseInt(str);
        }

        Collections.sort(numlist); // 오름차순으로 정렬 (-> index 2의 값이 중앙값)

        bw.write(Integer.toString(sum/5));
        bw.newLine();
        bw.write(Integer.toString(numlist.get(2)));
        bw.close(); // BufferWriter는 스트림 끝내기 필수
    }
}