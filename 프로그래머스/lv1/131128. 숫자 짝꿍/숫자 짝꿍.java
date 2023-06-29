import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] arrayX = new int[10];
        int[] arrayY = new int[10];
        int noZero = 0;
        
        String[] xSplit = X.split("");
        String[] ySplit = Y.split("");
        StringBuilder sb = new StringBuilder();
        
        for(String item: xSplit) {
            arrayX[Integer.parseInt(item)]++;
        }
        
        for(String item: ySplit) {
            arrayY[Integer.parseInt(item)]++;
        }
        
        
        for(int i=arrayX.length-1; i>-1; i--) {
            if(arrayX[i] != 0 || arrayY[i] != 0) {
                arrayX[i] = Math.min(arrayX[i], arrayY[i]);
                if(arrayX[i] > 0) noZero++;
                if(i == 0 && sb.toString().equals("")) {
                    answer = "0";
                    break;
                }
                for(int j=0; j<arrayX[i]; j++) {
                    sb.append(i);
                }
            }
        }

        if(answer != "0") {
            answer = sb.toString();
        }
        if(noZero < 1) answer = "-1";

        
        return answer;
    }
}