import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> runner = new HashMap<>();
        
        for(String item: participant) {
            if(runner.containsKey(item)) runner.put(item, runner.get(item) + 1);
            else runner.put(item, 1);
        }
        
        for(String comItem: completion) {
            if(runner.containsKey(comItem)) {
                if(runner.get(comItem) == 1) runner.remove(comItem);
                else runner.put(comItem, runner.get(comItem) - 1);
            }
        }
        
        for(String key: runner.keySet()) {
            answer = key;
        }
        
        return answer;
    }
}