import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int idx = 0;
        int cnt = 0;
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        
        for(int item: reserve) { reserveList.add(item); }
        
        for(int item: lost) {
            if(reserveList.contains(item)) {
                int index = reserveList.indexOf(item);
                reserveList.remove(index);
            } else lostList.add(item);
        }
        
        Collections.sort(reserveList);
        Collections.sort(lostList);
        
        System.out.println("초기 lostList: " + lostList);
        System.out.println("초기 reserveList: " + reserveList);
        System.out.println("==================================");
        
        for(int reserveItem: reserveList) {
            idx = 0;
            if(lostList.size() < 1) {
                break;
            } 
            
            while (idx < lostList.size()) {
                if(Math.abs(reserveItem - lostList.get(idx)) < 2 && lostList.size() >= 1){
                    // 오차절대값이 1보다 크면 앞뒤 학생이 아님
                    lostList.remove(idx);
                    System.out.println("제거: " + idx);
                    break;
                } else idx++;
                
                System.out.println("lostList: " + lostList);
                System.out.println("reserveItem: " + reserveItem);
                System.out.println("==================================");
            }
            
        }
        cnt = n - lostList.size();
        System.out.println("종료: " + cnt);

        return cnt;
    }
}