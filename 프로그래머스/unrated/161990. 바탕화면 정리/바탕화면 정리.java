import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        char[][] array = new char[wallpaper.length][wallpaper[0].length()];
        ArrayList<Integer> xaxis = new ArrayList<Integer>();
        ArrayList<Integer> yaxis = new ArrayList<Integer>();
        
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[i].length(); j++) {
                char idx = wallpaper[i].charAt(j);
                array[i][j] = idx;
                if(idx == '#') {
                    xaxis.add(i); yaxis.add(j);
                }
            }    
        }
        
        answer[0] = Collections.min(xaxis);
        answer[1] = Collections.min(yaxis);
        answer[2] = Collections.max(xaxis) + 1;
        answer[3] = Collections.max(yaxis) + 1;
        
        return answer;
    }
}