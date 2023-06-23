import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[][] category = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        int[] score = {-3, -2, -1, 0, 1, 2, 3};
        int[][] personal = new int[4][2];
        String testKey = ""; int testValue = 0;
        
        for(int i=0; i<survey.length; i++) {
            // 문항별 성격유형 + 점수 추출
            if(score[choices[i]-1] < 0) {
                testKey = survey[i].substring(0, 1);
                testValue = Math.abs(score[choices[i]-1]);
            } else if(score[choices[i]-1] > 0) {
                testKey = survey[i].substring(1,2);
                testValue = score[choices[i]-1];
            } else {
                testKey = "";
                testValue = 0;
            }
            
            System.out.println("testKey: " + testKey + ", testValue: " + testValue);
            
            // 문제 풀 때마다 점수 합산해서 유형별로 누적시키기
            for(int j=0; j<category.length; j++) {
                for(int k=0; k<category[0].length; k++) {
                    if(category[j][k].equals(testKey)) personal[j][k] += testValue;
                }
            }
        }
        
        
        // 지표번호별 점수 추출 및 유형 구분
        for(int i=0; i<personal.length; i++) {
            if(personal[i][0] < personal[i][1]) answer += category[i][1];
            else answer += category[i][0];
        }
        
        
        return answer;
    }
}