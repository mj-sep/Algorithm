import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int idx = 0;
        int score = 0; String bonus = ""; String option = "";
        int[] scoreByRoundN = new int[3];
        
        // 라운드별 점수
        String dartResultN = dartResult.replaceAll("[^0-9]", " ");
        dartResultN = dartResultN.replaceAll("\\s+", " ");
        String[] scoreByRound = dartResultN.split(" ");
        for(String item: scoreByRound) { scoreByRoundN[idx] = Integer.parseInt(item); idx++; }
        
        
        // 라운드별 보너스 및 옵션
        String dartResultB = dartResult.replaceAll("[0-9]", " ");
        dartResultB = dartResultB.replaceAll("\\s+", " ");
        dartResultB = dartResultB.substring(1, dartResultB.length());
        String[] bonusByRound = dartResultB.split(" ");
        System.out.println(Arrays.toString(bonusByRound));
        
        // 라운드별 계산
        idx = -1;
        for(int i=0; i<scoreByRound.length; i++) {
            score = Integer.parseInt(scoreByRound[i]);
            bonus = bonusByRound[i].substring(0, 1);
            if(bonusByRound[i].length() > 1) {
                option = bonusByRound[i].substring(1, 2);
            } else option = "None";
            
            // 보너스 점수 산출
            if(bonus.equals("D")) scoreByRoundN[i] = (int) Math.pow(score, 2);
            else if(bonus.equals("T")) scoreByRoundN[i] = (int) Math.pow(score, 3);
            
            // 옵션 점수 산출
            if(option.equals("*") && i == 0) {
                scoreByRoundN[i]*=2;
            } else if (option.equals("*") && i > 0) {
                scoreByRoundN[i-1]*=2;
                scoreByRoundN[i]*=2;
            } else if(option.equals("#")) {
                String minus = "-" + scoreByRoundN[i];
                scoreByRoundN[i] = Integer.parseInt(minus);
            }
            // System.out.println(Arrays.toString(scoreByRoundN));
        }
        
        
        // 점수 합산
        for(int i: scoreByRoundN) {
            answer += i;
        }
        
        
        return answer;
    }
}