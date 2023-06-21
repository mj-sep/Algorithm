import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String,Integer> memories = new HashMap<>();
        for(int i=0; i<name.length; i++) {
            memories.put(name[i], yearning[i]);    
        }
        
        System.out.println(photo.length);
        int[] answer = new int[photo.length];
        
        for(int i=0; i<photo.length; i++) {
            int sum = 0;
            for(String photoName: photo[i]) {
                if(memories.containsKey(photoName)) {
                    sum += memories.get(photoName);
                }
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}