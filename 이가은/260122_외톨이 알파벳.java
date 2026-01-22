import java.util.Arrays;

class Solution {
    public String solution(String input_string) {
        int[] cnt = new int[26];
        int[] front = new int[26];
       
        for (int i = 0; i < input_string.length(); i++) {
            char c = input_string.charAt(i);
            char charN = (char) (c - 'a') ;
            if ( i > 0 && cnt[charN] > 0  && input_string.charAt(i-1) != c) {
                front[charN]++;
            }
            cnt[charN]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] >= 2 && front[i] > 0) {
                char c = (char) (i + 97);
                sb.append(c);
            }
        }
        
        return sb.toString().length() > 0 ? sb.toString() : "N";
    }
}