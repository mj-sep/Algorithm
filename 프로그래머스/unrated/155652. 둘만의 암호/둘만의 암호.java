import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int idx = index;
        
        String[] skipArray = skip.split("");
        List<String> skiplist = Arrays.asList(skipArray);
        
        char[] sArray = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
            sArray[i] = s.charAt(i);
        }
        
        for(char item: sArray) {
            idx = index;
            int itemAscii = item;
            while (idx > 0) {
                itemAscii++;
                if(itemAscii > 122) itemAscii = 97;
                char itemAsciiCH = (char) itemAscii;
                String itemAsciiSTR = itemAsciiCH + "";
                System.out.println(itemAsciiSTR);
                if(!skiplist.contains(itemAsciiSTR)) idx--;
            }
            
            answer += (char)itemAscii;
        }
        
        return answer;
    }
}