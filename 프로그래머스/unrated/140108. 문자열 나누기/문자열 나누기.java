class Solution {
    public int solution(String s) {
        int answer = 0;
        int index = 0;
        int sameX = 0; int notsameX = 0;
        boolean check = false;
        
        String x = s.substring(index, 1);
        for(int i=0; i<s.length(); i++) {
            check = false;
            if(x.equals(s.substring(i, i+1))) sameX++;
            else notsameX++;
            
            // 횟수가 같아진다면
            if(sameX == notsameX) {
                answer++;
                if(i < s.length()-1) {
                    index = i+1;
                    x = s.substring(index, index+1);
                }                
                sameX = 0; notsameX = 0;
                check = true;
            }   
        }
        
        if(check == false) answer++;
        
        return answer;
    }
}