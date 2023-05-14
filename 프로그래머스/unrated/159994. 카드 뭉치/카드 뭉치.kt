class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer: String = "Yes"
        var cards1Idx = 0
        var cards2Idx = 0
        
        for(i in 0 until goal.size) {
            if(cards1[cards1Idx].equals(goal[i])) {
                // println("${cards1[cards1Idx]}에 ${goal[i]} 있음")
                if(cards1.size > cards1Idx + 1) cards1Idx++
            }
            else if (cards2[cards2Idx].equals(goal[i])) {
                // println("${cards2[cards2Idx]}에 ${goal[i]} 있음")
                if(cards2.size > cards2Idx + 1) cards2Idx++
            }
            else {
                //println("${cards1[cards1Idx]}와 ${cards2[cards2Idx]}에 ${goal[i]} 없음")
                answer="No"
                break;
            }
        }
        return answer
    }
}