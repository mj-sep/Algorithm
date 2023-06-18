import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase(); // 1단계
        String[] spl = new_id.split("");
        
        // 2단계
        for(int i=0; i<new_id.length(); i++) {
            if(spl[i].equals("-") || spl[i].equals("_") || spl[i].equals(".") 
               || spl[i].matches("[a-z]") || spl[i].matches("[0-9]")) answer += spl[i];
            else answer += "";
        }
        
        // 3단계
        answer = answer.replaceAll("\\.{2,}", ".");
        
        // 4단계
        if (answer.charAt(0) == '.') answer = answer.substring(1);
        else if(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);

        // 5단계
        if(answer.equals("")) answer += "a";
        
        // 6단계
        int answerLen = answer.length();
        if(answerLen > 15) answer = answer.substring(0, 15);
        if(answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);
        
        // 7단계
        while (answer.length() < 3) {
            char lastText = answer.charAt(answer.length()-1);
            answer += lastText;
        }
        
        
        return answer;
    }
}