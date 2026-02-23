import java.util.*;

class Solution {
    char[] alph = {'A', 'E', 'I', 'O', 'U'};
    StringBuilder sb = new StringBuilder();
    char[] output;
    
    public int solution(String word) {
        for(int i = 1; i <= 5; i++) {
            output = new char[i];
            p(1, i);
        }
        
        List<String> list = Arrays.asList(sb.toString().split(" "));
        Collections.sort(list);
        
        return list.indexOf(word) + 1;  // 인덱스는 0부터이므로
    }
    
    void p(int dept, int n) {
        if(dept == n + 1) {
            String word = String.valueOf(output);
            sb.append(word).append(" ");
            return;
        }
        for(char a : alph) {
            output[n - dept] = a;
            p(dept + 1, n);
        }
    }
}