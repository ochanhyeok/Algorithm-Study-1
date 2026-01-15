import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    static Map<String, ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        // 1) info 전처리 
        for (String s : info) {
            String[] parts = s.split(" ");
            String[] cond = {parts[0], parts[1], parts[2], parts[3]};
            int score = Integer.parseInt(parts[4]);
            
            // 비트마스크로 16개 조합
            for (int mask = 0; mask < (1 << 4); mask++) {
                StringBuilder key = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    if ((mask & (1 << i)) != 0) key.append("-"); // mask의 i번째 비트가 1인가?
                    else key.append(cond[i]);
                    key.append(" ");
                }
                String k = key.toString();
                map.computeIfAbsent(k, z -> new ArrayList<>()).add(score);
            }
        }
        
        // 2) 각 key의 점수 리스트 정렬 (이분탐색용)
        for (ArrayList<Integer> list : map.values()) {
            Collections.sort(list);
        }
        
        // 3) query 처리 
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            // "and" 제거 후 파싱
            String q = query[i].replace(" and ", " ");
            String[] parts = q.split(" ");
            String key = parts[0] + " " + parts[1] + " " + parts[2] + " " + parts[3] + " ";
            int targetScore = Integer.parseInt(parts[4]);
            
            // query를 "key 문자열"로 만들어 map에서 ㅏ로 꺼냄
            ArrayList<Integer> list = map.get(key);
            if (list == null) {
                answer[i] = 0;
                continue;
            }
            
            // targetScore가 시작되는 위치
            int idx = lowerBound(list, targetScore);
            answer[i] = list.size() - idx;
        }
        
        return answer;
    }
    
    static int lowerBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (list.get(mid) >= target)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}