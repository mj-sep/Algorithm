import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        int length = 0;
        Stack<Integer> st = new Stack<Integer>();
        
        for(int item: ingredient) {
            st.push(item);
            int stSize = st.size();
            if(stSize >= 4) {
                if(st.get(stSize-1) == 1 && st.get(stSize-2) == 3
                  && st.get(stSize-3) == 2 && st.get(stSize-4) == 1) {
                    answer++;
                    for(int i=0; i<4; i++) st.pop();
                }
            }
        }
        
        
        
        return answer;
    }
}