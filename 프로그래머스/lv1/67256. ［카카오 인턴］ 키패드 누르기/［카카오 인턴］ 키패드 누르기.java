import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] near = {{1,3}, {0,0}, {1,0}, {2,0}, {0,1}, {1,1}, 
                        {2,1}, {0,2}, {1,2}, {2,2}, {0,3}, {2,3}};
        int[] present = {10, 11}; // *을 10으로 #을 11로 임의 표기
        
        for(int i=0; i<numbers.length; i++) {
            int idxHand = numbers[i];
            if(idxHand == 1 || idxHand == 4 || idxHand == 7) {
                answer += "L";
                present[0] = idxHand;
            } else if (idxHand == 3 || idxHand == 6 || idxHand == 9) {
                answer += "R";
                present[1] = idxHand;
            } else {
                int x = near[idxHand][0];
                int y = near[idxHand][1];
                
                // [목표 좌표, 왼손 좌표, 오른손 좌표]
                int[][] middleColumn = {{x,y}, {near[present[0]][0], near[present[0]][1]}, 
                                      {near[present[1]][0], near[present[1]][1]} };
                
                int lengL = Math.abs(middleColumn[1][0] - middleColumn[0][0]) 
                    + Math.abs(middleColumn[1][1] - middleColumn[0][1]);
                int lengR = Math.abs(middleColumn[2][0] - middleColumn[0][0]) 
                    + Math.abs(middleColumn[2][1] - middleColumn[0][1]);
                
                if(lengL < lengR) {
                    answer += "L";
                    present[0] = idxHand;
                } else if (lengL > lengR) {
                    answer += "R";
                    present[1] = idxHand;
                } else {
                    if(hand.equals("left")) {
                        answer += "L";
                        present[0] = idxHand;
                    } else {
                        answer += "R";
                        present[1] = idxHand;
                    }
                }
            }
        }
        
        return answer;
    }
}