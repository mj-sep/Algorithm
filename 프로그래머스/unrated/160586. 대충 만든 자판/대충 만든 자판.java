import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int[] result = new int[targets.length];
        
        for(String key : keymap) {
            for(int i=0 ; i<key.length() ; i++) {
                char c = key.charAt(i);
                if(!hash.containsKey(c) || i<hash.get(c)) {
                    hash.put(c, i+1);
                }
            }
        }
        
        for(int i=0 ; i<targets.length ; i++) {
            int cnt = 0;
            for(int j=0 ; j<targets[i].length() ; j++) {
                char c = targets[i].charAt(j);
                if(!hash.containsKey(c)) {
                    cnt = 0;
                    break;
                } else {
                    cnt += hash.get(c);
                }
            }
            result[i] = cnt==0?-1:cnt;
        }
        return result;
    }
}