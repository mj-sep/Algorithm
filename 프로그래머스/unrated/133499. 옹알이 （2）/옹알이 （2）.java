class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] pronun = {"aya", "ye", "woo", "ma"};
        for(String item: babbling) {
            item = item.replaceAll("ayaaya|yeye|woowoo|mama", " ");
            item = item.replaceAll("aya|ye|woo|ma", "");
            if(item.equals("")) answer++;
        }
        return answer;
    }
}