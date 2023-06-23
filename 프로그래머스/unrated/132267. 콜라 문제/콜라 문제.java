class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int quotient = 0; int remainder = 0;
        
        while (n > a-1) {
            quotient = n / a * b;
            remainder = n % a;
            answer += quotient;
            n = quotient + remainder;
        }
        
        return answer;
    }
}