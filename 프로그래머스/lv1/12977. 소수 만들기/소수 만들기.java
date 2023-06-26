import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean check = false;
        List<Integer> list = new ArrayList<>();

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");
        
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    list.add(sum);
                }
            }
        }
        
        for(int i: list) {
            int cnt = 2;
            answer++;
            while(cnt < i) {
                if(i%cnt == 0) {
                    answer--;
                    break;
                }
                cnt++;
            }
        }

        return answer;
    }
}