import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int input_n = Integer.parseInt(input);
        int cnt = 0;

        for(int i=1; i<=input_n; i++){
            char[] input_num = Integer.toString(i).toCharArray();
            cnt += hansu(input_num);
        }

        bw.write(Integer.toString(cnt));
        bw.close();
    }

    public static int hansu(char[] input_num){
        int han_count = 0;
        boolean arith = false; // 등차수열 여부
        int arith_num = 0; // 등차값
        
        if(input_num.length > 2) { // 세자리 수 이상이면 
            arith_num = input_num[1] - input_num[0]; // 등차값 구하고 루프 돌리며 확인
            for(int i=2; i<input_num.length; i++){ 
                if(input_num[i] - input_num[i-1] != arith_num) {
                    arith = false;
                    break;
                }
                else arith = true;
            }
            if(arith == true) {
                han_count++;
                arith = false;
            }
        } else han_count++; // 두자리 수 이하는 무조건 등차
        
        return han_count;
    }
}