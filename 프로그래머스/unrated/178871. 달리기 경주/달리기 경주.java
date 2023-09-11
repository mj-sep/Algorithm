import java.util.*;


class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> play = new HashMap<>();
        HashMap<Integer, String> score = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            play.put(players[i], i);
            score.put(i, players[i]);
        }
        
        for(String name: callings) {
            
            int idx = play.get(name); // 현재 등수
            String name2 = score.get(idx-1); // 추월당한 사람 이름

            play.put(name2, idx);
            play.put(name, idx-1);
            score.put(idx-1, name);
            score.put(idx, name2);
        }
        
        
        Iterator<Map.Entry<String, Integer>> itr = play.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            answer[entry.getValue()] = entry.getKey();
        }
        
        return answer;
    }
}