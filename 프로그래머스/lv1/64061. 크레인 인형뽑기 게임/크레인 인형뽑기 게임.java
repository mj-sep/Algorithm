import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int movesId = 0;
        List<Integer> stack = new ArrayList<>();
        
        while(movesId < moves.length){
            for(int i=0; i<board[0].length; i++) {
                int movesIdx = moves[movesId]-1;
                if(board[i][movesIdx] != 0) {
                    stack.add(board[i][movesIdx]);
                    board[i][movesIdx] = 0;
                    break;
                }
            }
            movesId++;
        }
        
        boolean type = false;
        while(true) {
            for(int i=1; i<stack.size(); i++) {
                // System.out.println(type);
                if(stack.get(i-1) == stack.get(i)) {
                    // System.out.println(stack.get(i-1) + ", " + stack.get(i));
                    type = true;
                    answer += 2;
                    stack.remove(i);
                    stack.remove(i-1);
                }
            }
            if(type == false) break;
            type = false;
        }
        
        System.out.println(stack);
        
        return answer;
    }
}