import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        String[] sortByStrings = new String[strings.length];
        int idx = 0;
        
        for(int i=0; i<strings.length; i++) {
            sortByStrings[i] = strings[i].substring(n, n+1) + strings[i];
        }
        
        Arrays.sort(sortByStrings);
        
        for(String item: sortByStrings) {
            answer[idx] = item.substring(1, item.length());
            idx++;
        }
        
        
        
        return answer;
    }
}