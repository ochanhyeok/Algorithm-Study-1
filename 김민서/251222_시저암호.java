import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char i : s.toCharArray()) {
            char c;
            if(i >= 'A' && i <= 'Z') {
                c = (char)('A' + (i - 'A' + n) % 26);
                sb.append(c);
            } else if (i >= 'a' && i <= 'z') {
                c = (char)('a' + (i - 'a' + n) % 26);
                sb.append(c);
            } else {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}