class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];
        
        for(int i=0; i<n+1; i++) {
            arr[i] = i;
        }
        
        arr[1] = 0;
        
        // 소수 탐색
        for(int i=2; i<n+1; i++) {
            // 만약 이전에 찾았던 소수의 배수 값일 경우 계산 없이 다음으로 이동
            if(arr[i] == 0) continue;
            // 에라토스테네스 채 이용 -> 배수의 수는 소수가 아니라고 정의
            for(int j=i*2; j<n+1; j+=i) { // 4, 6, 8, ...
                arr[j] = 0;
            }
        }
        
        for(int i: arr) {
            if(i != 0) answer++;
        }
        
        return answer;
    }
}