import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        String[][] reporter_id = new String[id_list.length][2];
        ArrayList<String> freeze_id = new ArrayList<>();
        HashMap<String, Integer> list = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++) {
            reporter_id[i][0] = id_list[i];
            reporter_id[i][1] = " ";
        }
        
        // 동일 신고 결과 중복 제거
        HashSet<String> removeDuplication = new HashSet<>(Arrays.asList(report));
        report = removeDuplication.toArray(new String[0]);
        
        // 누적 신고 횟수 집계
        for(String report_info: report) {
            String[] userList = report_info.split(" ");
            for(int i=0; i<reporter_id.length; i++) {
                if(reporter_id[i][0].equals(userList[0])) {
                    if(reporter_id[i][1] != null) reporter_id[i][1] += " " + userList[1];
                    else reporter_id[i][1] = userList[1];
                }
            }
            if(list.containsKey(userList[1])) list.put(userList[1], list.get(userList[1]) + 1);
            else list.put(userList[1], 1);
               
            
            if(list.get(userList[1]) == k) freeze_id.add(userList[1]);
        }
        
        // 메일 전송할 신고자 추리기
        if(freeze_id.size() > 0) {
            for(int i=0; i<reporter_id.length; i++) {
                for (String id: freeze_id) {
                    String[] idList = reporter_id[i][1].split(" ");
                    for(String id2: idList) {
                        if(id2.equals(id)) answer[i]++;
                    }
                }
            }
        }
    
        return answer;
    }
}