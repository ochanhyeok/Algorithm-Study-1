import java.util.*;

class Solution {
    
    public int solution(String word) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 1);
        map.put('E', 2);
        map.put('I', 3);
        map.put('O', 4);
        map.put('U', 5);
        
        char[] charArr = word.toCharArray();
        int length = word.length();
        StringBuilder wordSb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            char c = charArr[i];
            wordSb.append(map.get(c));
        }
        
        answer = recur("", wordSb.toString(), 0);
        
        return answer;
    }
    
    static int recur(String current, String target, int cnt) {
        if (!current.isEmpty()) {
            cnt++;
            if (current.equals(target)) {
                return cnt;
            }
        }
        
        if (current.length() == 5) return -cnt; 
      
        for (int i = 1; i <= 5; i++) {
            String next = current + i + "";
            int res = recur(next, target, cnt);
            if (res > 0) return res;
            cnt = -res; // 부호 음수 -> 양수
        }

        return -cnt;
    }
}