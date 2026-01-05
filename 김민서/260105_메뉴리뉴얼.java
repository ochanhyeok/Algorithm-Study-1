import java.util.*;

class Solution {
    static String[] order;
    static char[] arr; // order -> char[]로
    static char[] output; // 가능한 조합
    static Map<String, Integer> map = new HashMap<>();  // 최대 빈도수 찾기 위해
    static List<String> list = new ArrayList<>(); // 코스 수 별 최대 빈도 가진 조합만 넣기
    
    public String[] solution(String[] orders, int[] course) {
        order = orders;
        
        for(int j : course) {
            map = new HashMap<>();
            
            for(int i = 0; i < order.length; i++) {
                arr = order[i].toCharArray();
                Arrays.sort(arr);           // 미리 문자열 정렬
                output = new char[j];
                c(0, 0, j);
            }
            
            int max = 0;                // 조합 빈도 중 최댓값 찾기
            for (int v : map.values()) {
                max = Math.max(max, v);
            }

            if (max >= 2) {
                for (String key : map.keySet()) {
                    if (map.get(key) == max) {
                        list.add(key);
                    }
                }
            }
        }
        
        Collections.sort(list);          // 결과 정렬
        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }
    
    public static void c(int dept, int idx, int r){
        
        if(dept == r){
            String str = new String(output);
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
        
        for(int i=idx; i<arr.length; i++){
            output[dept] = arr[i];
            c(dept + 1, i + 1, r);
        }
    }
}