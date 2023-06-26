import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int inStage = 0; // 현재 스테이지 도전 중인 사람 수
        int endStage = 0; // 해당 스테이지 거쳐 간 사람 수
        double[] failure = new double[N];
        boolean check = false;
        
        Arrays.sort(stages);
        
        for(int i=1; i<N+1; i++) {
            inStage = 0; endStage = 0;
            for(int j=0; j<stages.length; j++) {
                if(stages[j] > i-1) endStage++;
                if(stages[j] == i) inStage++;
            }
            //System.out.println("i=" + i + ", (in,end): " + inStage + ", " + endStage);
            failure[i-1] = (double) inStage/endStage;
            answer[i-1] = i;
        }
        
        do {
            check = false;
            for(int i=0; i<failure.length-1; i++) {
                if(failure[i] < failure[i+1]) {
                    double temp = failure[i+1];
                    failure[i+1] = failure[i];
                    failure[i] = temp;
                
                    int temp2 = answer[i+1];
                    answer[i+1] = answer[i];
                    answer[i] = temp2;
                    
                    check = true;
                }
            }
        } while (check == true);
        
        //System.out.println(Arrays.toString(failure));
        return answer;
    }
}