import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        int[] quota = new int[food.length-1]; // 인당 할당량
        List<Integer> forReverse = new ArrayList<>();
        
        for(int i=1; i<food.length; i++) {
            quota[i-1] = food[i] / 2;
        }
        
        int idx = 1;
        for(int item: quota) {
            for(int i=0; i<item; i++) {
                answer += idx;
                forReverse.add(idx);
            }            
            idx++;
        }
        
        
        answer += 0;
        Collections.reverse(forReverse);
        
        for(int item: forReverse) {
            answer += item;           
        }
        
        return answer;
    }
}