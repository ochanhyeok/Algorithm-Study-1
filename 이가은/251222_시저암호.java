class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        int k = 0;
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(' ');
                continue;
            }
            
            k = c >= 'A' && c <= 'Z' ? 'A' : 'a';
            
            char result = (char)(((c + n) - k) % 26 + k);
            answer.append(Character.toString(result));
        }
        
        return answer.toString();
    }
}