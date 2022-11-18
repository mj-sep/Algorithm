import java.util.ArrayList;

class Solution {
    public ArrayList solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int min=arr[0];
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]<min) min=arr[i];
        }
        
        for(int i=0; i<arr.length; i++){
            if(arr.length==1) answer.add(-1);
            else if(arr[i]!=min) answer.add(arr[i]);
        }
        return answer;
    }
}